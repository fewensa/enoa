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
package io.enoa.docker.parser;

import io.enoa.docker.DockerConfig;
import io.enoa.docker.dret.DResp;
import io.enoa.docker.dret.DRet;
import io.enoa.docker.dret.container.*;
import io.enoa.docker.dret.dockerinfo.EDockerInfo;
import io.enoa.docker.dret.image.*;
import io.enoa.docker.dret.network.ENetworPrune;
import io.enoa.docker.dret.network.ENetwork;
import io.enoa.docker.dret.network.ENetworkCreated;
import io.enoa.toolkit.EoConst;
import io.enoa.toolkit.binary.EnoaBinary;
import io.enoa.toolkit.value.Void;

import java.util.List;

@FunctionalInterface
public interface DIParser<T> {

  static DIParser<Void> voidx() {
    return EVoidParser.instance();
  }

  static DIParser<EDockerInfo> dockerinfo() {
    return EDockerInfoParser.instance();
  }

  static DIParser<List<EContainer>> listcontainer() {
    return EListContainerParser.instance();
  }

  static DIParser<EContainerCreated> created() {
    return EContainerCreatedParser.instance();
  }

  static DIParser<ECInspect> containerinspect() {
    return EContainerInspectParser.instance();
  }

  static DIParser<EProcesses> top() {
    return EProcessParser.instance();
  }

  static DIParser<String> logs() {
    return ELogsParser.instance();
  }

  static DIParser<List<EChange>> changes() {
    return EChangesParser.instance();
  }

  static DIParser<EStatistics> statistics() {
    return EStatisticsParser.instance();
  }

  static DIParser<EUpdate> update() {
    return EUpdateParser.instance();
  }

  static DIParser<ECWait> waitx() {
    return EWaitParser.instance();
  }

  static DIParser<ECPrune> containerprune() {
    return ECPruneParser.instance();
  }

  static DIParser<List<EImage>> image() {
    return EImageParser.instance();
  }

  static DIParser<EIPrune> buildprune() {
    return EIPruneParser.instance();
  }

  static DIParser<EIInspect> imageinspect() {
    return EImageInspectParser.instance();
  }

  static DIParser<List<EHistory>> imagehistory() {
    return EImageHistoryParser.instance();
  }

  static DIParser<List<EIRemove>> imageremove() {
    return EImageRemoveParser.instance();
  }

  static DIParser<List<EISearch>> imagesearch() {
    return EImageSearchParser.instance();
  }

  static DIParser<EImagePrune> imageprune() {
    return EImagePruneParser.instance();
  }

  static DIParser<EICommit> imagecommit() {
    return EImageCommitParser.instance();
  }

  static DIParser<EnoaBinary> binary() {
    return EBinaryParser.instance();
  }

  static DIParser<List<ENetwork>> networklist() {
    return ENetworkListParser.instance();
  }

  static DIParser<ENetwork> networkinspect() {
    return ENetworkInspectParser.instance();
  }

  static DIParser<ENetworkCreated> networkcreated() {
    return ENetworkCreatedParser.instance();
  }

  static DIParser<ENetworPrune> networkprune() {
    return ENetworkPruneParser.instance();
  }

  /**
   * only use not create dresp object
   * <p>
   * todo a better way
   *
   * @param config config
   * @param text   text
   * @return dret
   */
  default DRet<T> parse(DockerConfig config, String text) {
    return this.parse(config, DResp.create(100, "application/json", text.getBytes(EoConst.CHARSET)));
  }

  DRet<T> parse(DockerConfig config, DResp resp);

}
