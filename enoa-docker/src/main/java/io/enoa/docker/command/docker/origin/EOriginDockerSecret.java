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

import io.enoa.docker.dqp.common.DQPFilter;
import io.enoa.docker.dket.docker.DResp;

public interface EOriginDockerSecret {

  default DResp list() {
    return this.list(null);
  }

  DResp list(DQPFilter dqp);

  DResp create(String body);

  DResp inspect(String id);

  DResp remove(String id);

  DResp update(String id, long version, String body);

}
