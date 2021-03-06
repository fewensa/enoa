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
package io.enoa.docker.dqp.docker.plugin;

import io.enoa.docker.dqp.DQR;
import io.enoa.docker.dqp.common.DQPRegistryAuth;

public class DQPPluginUpgrade extends DQPRegistryAuth {

  private String remote;

  public static DQPPluginUpgrade create() {
    return new DQPPluginUpgrade();
  }

  public DQPPluginUpgrade remote(String remote) {
    this.remote = remote;
    return this;
  }

  @Override
  public DQR dqr() {
    return null;
  }

}
