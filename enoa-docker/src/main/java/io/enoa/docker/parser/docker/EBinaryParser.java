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
package io.enoa.docker.parser.docker;

import io.enoa.docker.DockerConfig;
import io.enoa.docker.dket.docker.DResp;
import io.enoa.toolkit.binary.EnoaBinary;

class EBinaryParser extends AbstractParser<EnoaBinary> {
  private static class Holder {
    private static final EBinaryParser INSTANCE = new EBinaryParser();
  }

  static EBinaryParser instance() {
    return Holder.INSTANCE;
  }

  @Override
  public EnoaBinary ok(DockerConfig config, DResp origin) {
    return origin.binary();
  }
}
