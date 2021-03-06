/*
 * Copyright (c) 2018, enoa (fewensa@enoa.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.enoa.docker.enqueue;

import io.enoa.docker.promise.DockerDoneargPromise;
import io.enoa.promise.DoneArgPromise;
import io.enoa.promise.arg.PromiseArg;
import io.enoa.promise.arg.PromiseCapture;
import io.enoa.promise.arg.PromiseVoid;
import io.enoa.promise.async.AsyncRunner;
import io.enoa.promise.builder.EPDoneArgPromiseBuilder;
import io.enoa.promise.Promise;
import io.enoa.toolkit.collection.CollectionKit;

import java.util.concurrent.ExecutorService;

class _DockerDoneargEnqueueImpl<T> implements EnqueueDoneargDocker<T> {

  private ExecutorService executor;
  private AsyncRunner<T> runner;

  _DockerDoneargEnqueueImpl(ExecutorService executor, AsyncRunner<T> runner) {
    this.executor = executor;
    this.runner = runner;
  }

  @Override
  public DockerDoneargPromise<T> enqueue() {
    EPDoneArgPromiseBuilder<T> donearg = Promise.builder().donearg();
    this.executor.execute(() -> {
      try {
        String oldName = Thread.currentThread().getName();
        T ret = this.runner.run();
        if (CollectionKit.isEmpty(donearg.dones()))
          return;
        donearg.dones().forEach(done -> done.execute(ret));
      } catch (Exception e) {
        if (CollectionKit.isEmpty(donearg.captures())) {
          e.printStackTrace();
          return;
        }
        donearg.captures().forEach(capture -> capture.execute(e));
      } finally {
        if (donearg.always() != null)
          donearg.always().execute();
      }
    });

    DoneArgPromise<T> promise = donearg.build();
    return new DockerDoneargPromise<T>() {
      @Override
      public DockerDoneargPromise<T> done(PromiseArg<T> done) {
        promise.done(done);
        return this;
      }

      @Override
      public DockerDoneargPromise<T> capture(PromiseCapture capture) {
        promise.capture(capture);
        return this;
      }

      @Override
      public void always(PromiseVoid always) {
        promise.always(always);
      }
    };
  }
}
