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
package io.enoa.docker.command.docker.origin;

import io.enoa.docker.dqp.common.DQPResize;
import io.enoa.docker.ret.docker.DResp;

public class EUNIXSOCKETDockerExec implements EOriginDockerExec {

  private EnoaUNIXSOCKETDocker docker;

  EUNIXSOCKETDockerExec(EnoaUNIXSOCKETDocker docker) {
    this.docker = docker;
  }

  @Override
  public DResp exec(String id, String body) {
    return null;
  }

  @Override
  public DResp start(String id, String body) {
    return null;
  }

  @Override
  public DResp resize(String id, DQPResize dqp) {
    return null;
  }

  @Override
  public DResp inspect(String id) {
    return null;
  }
}
