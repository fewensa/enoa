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

import io.enoa.docker.dqp.image.DQPBuild;
import io.enoa.docker.dqp.image.DQPListImage;
import io.enoa.docker.dqp.image.DQPSearch;
import io.enoa.docker.dqp.image.DQPTag;
import io.enoa.docker.dret.DRet;
import io.enoa.docker.dret.image.*;
import io.enoa.docker.stream.DStream;
import io.enoa.json.Json;
import io.enoa.toolkit.map.Kv;
import io.enoa.toolkit.value.Void;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

@Ignore
public class DockerImageTest extends AbstractDockerTest {


  @Test
  public void testList() {
    DRet<List<EImage>> ret = Docker.image().list(DQPListImage.create().all());
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }

  @Test
  public void testBuild() {
    DQPBuild dqp = DQPBuild.create()
      .t("enoa-alpine:0.1")
      .forcerm();
    String dockerfile = "FROM ubuntu:16.04\n" +
      "RUN mkdir demo";
//    String ret = Docker.origin().image().build(dqp, dockerfile, DStream.<String>builder(System.out::print).build());
//    System.out.println();
//    System.out.println("done===");

    DRet<List<Kv>> ret = Docker.image().build(dqp, dockerfile, DStream.<Kv>builder(kv -> System.out.println(Json.toJson(kv))).build());
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }

  @Test
  public void testPrunebuild() {
    DRet<EIPrune> ret = Docker.image().prunebuild();
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }

  @Test
  public void testInspect() {
    DRet<EIInspect> ret = Docker.image().inspect("ubuntu:16.04");
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }

  @Test
  public void testHistory() {
    DRet<List<EHistory>> ret = Docker.image().history("ubuntu:16:04");
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }

  @Test
  public void testPush() {
    DRet<Void> ret = Docker.image().push("ubuntu:16:04");
    Assert.assertTrue(ret.ok());
    System.out.println(ret);
  }

  @Test
  public void testTag() {
    DRet<Void> ret = Docker.image().tag("ubuntu:16.04", DQPTag.create()
      .repo("registry.host.com/ubuntu")
      .tag("16:04"));
    Assert.assertTrue(ret.ok());
    System.out.println(ret);
  }

  @Test
  public void testRemove() {
    DRet<List<EIRemove>> ret = Docker.image().remove("ubuntu:16.04");
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }

  @Test
  public void testSearch() {
    DRet<List<EISearch>> ret = Docker.image().search(DQPSearch.create().term("nginx"));
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }

  @Test
  public void testPruneimage() {
    DRet<EImagePrune> ret = Docker.image().pruneimage();
    Assert.assertTrue(ret.ok());
    String json = Json.toJson(ret.data());
    System.out.println(json);
  }

}
