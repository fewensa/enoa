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
package io.enoa.docker.command.hub.origin;

import io.enoa.docker.dqp.common.DQPPage;
import io.enoa.docker.dqp.dockerhub.DQPSearch;
import io.enoa.docker.ret.registry.RResp;

public class EOriginDockerhubImpl implements OriginDockerhub {

  @Override
  public RResp explore(DQPPage dqp) {
    return null;
  }

  @Override
  public RResp search(DQPSearch dqp) {
    return null;
  }

  @Override
  public RResp inspect(String repository) {
    return null;
  }

  @Override
  public RResp tags(String repository, DQPPage dqp) {
    return null;
  }

  @Override
  public RResp dockerfile(String repository) {
    return null;
  }

  @Override
  public RResp autobuild(String repository) {
    return null;
  }

  @Override
  public RResp history(String repository, DQPPage dqp) {
    return null;
  }
}
