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
package io.enoa.http.protocol.enoa;

import io.enoa.http.protocol.HttpResponse;

public class DefaultHttpReporter implements IHttpReporter {


  private static class Holder {
    private static final DefaultHttpReporter INSTANCE = new DefaultHttpReporter();
  }

  private DefaultHttpReporter() {

  }

  public static IHttpReporter instance() {
    return Holder.INSTANCE;
  }

  @Override
  public void report(HttpResponse response) {
    System.out.println(response);
  }
}
