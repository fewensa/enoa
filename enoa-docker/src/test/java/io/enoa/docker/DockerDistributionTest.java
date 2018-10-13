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
package io.enoa.docker;

import io.enoa.docker.dret.DRet;
import io.enoa.docker.dret.distribution.EDistribution;
import io.enoa.json.Json;
import org.junit.Assert;
import org.junit.Test;

public class DockerDistributionTest extends AbstractDockerTest {

  @Test
  public void testDistribution() {
    DRet<EDistribution> ret = Docker.distribution().distribution("nginx");
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }

}
