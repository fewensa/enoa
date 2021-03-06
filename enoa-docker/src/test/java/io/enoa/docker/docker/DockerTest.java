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
package io.enoa.docker.docker;

import io.enoa.docker.AbstractDockerTest;
import io.enoa.docker.Docker;
import io.enoa.docker.dket.docker.DRet;
import io.enoa.docker.dket.docker.dockerinfo.EDockerInfo;
import io.enoa.docker.dket.docker.run.EDRun;
import io.enoa.docker.dqp.DQP;
import io.enoa.docker.dqp.docker.container.DQPContainerCreate;
import io.enoa.json.Json;
import io.enoa.toolkit.digest.UUIDKit;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class DockerTest extends AbstractDockerTest {


  @Test
  public void testInfo() {
    DRet<EDockerInfo> ret = Docker.info();
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }


  private EDRun gitbranch() {
    String name = UUIDKit.next(false);
    DQPContainerCreate dqp = DQP.docker().container().create()
      .name(name)
      .image("alpine/git:latest")
      .interactive()
      .tty()
      .rm()
//      .volume("/anuz/tmp/preacher/asgh:/git")
      .volume("/d/data/tmp/preacher/zheok:/git")
      .cmd("branch")
      .cmd("-a");
    DRet<EDRun> ret = Docker.run(name, dqp);
    Assert.assertTrue(ret.ok());
    return ret.data();
  }

  @Test
  public void testRun() {
    EDRun edrun = this.gitbranch();
    System.out.println(Json.toJson(edrun));
//    Assert.assertFalse(text.contains("&"));
//    System.out.println("text".substring(4));
  }

}
