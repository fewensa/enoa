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
package io.enoa.docker.command.docker.eo;

import io.enoa.docker.command.docker.generic.EGenericDockerDistribution;
import io.enoa.docker.command.docker.generic.GenericDocker;
import io.enoa.docker.parser.docker.DIParser;
import io.enoa.docker.dket.docker.DRet;
import io.enoa.docker.dket.docker.distribution.EDistribution;

public class EnoaDockerDistribution {


  private GenericDocker docker;
  private EGenericDockerDistribution distribution;

  EnoaDockerDistribution(GenericDocker docker) {
    this.docker = docker;
    this.distribution = docker.distribution();
  }

  public DRet<EDistribution> distribution(String id) {
    return this.distribution.distribution(DIParser.distribution(), id);
  }

}
