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
import io.enoa.docker.dket.docker.dockerinfo.*;
import io.enoa.toolkit.collection.CollectionKit;
import io.enoa.toolkit.convert.ConvertKit;
import io.enoa.toolkit.date.DateKit;
import io.enoa.toolkit.map.Kv;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class EDockerInfoParser extends AbstractParser<EDockerInfo> {

  private static class Holder {
    private static final EDockerInfoParser INSTANCE = new EDockerInfoParser();
  }

  static EDockerInfoParser instance() {
    return Holder.INSTANCE;
  }

  @Override
  public EDockerInfo ok(DockerConfig config, DResp resp) {
    Kv kv = config.json().parse(resp.string(), Kv.class);
    EDockerInfo edi = new EDockerInfo.Builder()
      .id(kv.string("ID"))
      .containers(kv.integer("Containers"))
      .containersrunning(kv.integer("ContainersRunning"))
      .containerspaused(kv.integer("ContainersPaused"))
      .containersstopped(kv.integer("ContainersStopped"))
      .images(kv.integer("Images"))
      .driver(kv.string("Driver"))
      .driverstatus(this.driverstatus(kv))
      .systemstatus(kv.get("SystemStatus"))
      .plugins(this.plugin(kv))
      .memorylimit(kv.bool("MemoryLimit"))
      .swaplimit(kv.bool("SwapLimit"))
      .kernelmemory(kv.bool("KernelMemory"))
      .cpucfsperiod(kv.bool("CpuCfsPeriod"))
      .cpucfsquota(kv.bool("CpuCfsQuota"))
      .cpushares(kv.bool("CPUShares"))
      .cpuset(kv.bool("CPUSet"))
      .ipv4forwarding(kv.bool("IPv4Forwarding"))
      .bridgenfiptables(kv.bool("BridgeNfIptables"))
      .bridgenfip6tables(kv.bool("BridgeNfIp6tables"))
      .debug(kv.bool("Debug"))
      .nfd(kv.integer("NFd"))
      .oomkilldisable(kv.bool("OomKillDisable"))
      .ngoroutines(kv.integer("NGoroutines"))
      .systemtime(DateKit.parse(kv.string("SystemTime"), "yyyy-MM-dd'T'HH:mm:ss.SSS"))
      .loggingdriver(kv.string("LoggingDriver"))
      .cgroupdriver(kv.string("CgroupDriver"))
      .neventslistener(kv.integer("NEventsListener"))
      .kernelversion(kv.string("KernelVersion"))
      .operatingsystem(kv.string("OperatingSystem"))
      .ostype(kv.string("OSType"))
      .architecture(kv.string("Architecture"))
      .indexserveraddress(kv.string("IndexServerAddress"))
      .registryconfig(this.registryconfig(kv, "RegistryConfig"))
      .ncpu(kv.integer("NCPU"))
      .memtotal(kv.doubler("MemTotal"))
      .genericresources(kv.get("GenericResources"))
      .dockerrootdir(kv.string("DockerRootDir"))
      .httpproxy(kv.string("HttpProxy"))
      .httpsproxy(kv.string("HttpsProxy"))
      .noproxy(kv.string("NoProxy"))
      .name(kv.string("Name"))
      .labels(this.labels(kv))
      .experimentalbuild(kv.bool("ExperimentalBuild"))
      .serverversion(kv.string("ServerVersion"))
      .clusteradvertise(kv.string("ClusterAdvertise"))
      .clusterstore(kv.string("ClusterStore"))
      .runtimes(AEExtra.runtimes(kv, "Runtimes"))
      .defaultruntime(kv.string("DefaultRuntime"))
      .swarm(this.swarm(kv))
      .liverestoreenabled(kv.bool("LiveRestoreEnabled"))
      .isolation(kv.string("Isolation"))
      .initbinary(kv.string("InitBinary"))
      .containerdcommit(this.comment(kv, "ContainerdCommit"))
      .runccommit(this.comment(kv, "RuncCommit"))
      .initcommit(this.comment(kv, "InitCommit"))
      .build();
    CollectionKit.clear(kv);
    return edi;
  }

  private List<String[]> driverstatus(Kv kv) {
    List<List> dss = kv.as("DriverStatus");
    return dss.stream()
      .map(item -> (String[]) item.stream().map(Object::toString).toArray(String[]::new))
      .collect(Collectors.toList());
  }

  private EDIPlugin plugin(Kv kv) {
    EDIPlugin.Builder builder = new EDIPlugin.Builder();
    Map map = kv.as("Plugins");
    Object volume = map.get("Volume");
    if (volume instanceof List) {
      List vols = (List) volume;
      builder.volume((String[]) vols.toArray(new String[vols.size()]));
    }
    Object network = map.get("Network");
    if (network instanceof List) {
      List nets = (List) network;
      builder.network((String[]) nets.toArray(new String[nets.size()]));
    }
    builder.authorization(map.get("Authorization"));
    Object log = map.get("Log");
    if (log instanceof List) {
      List lgs = (List) log;
      builder.log((String[]) lgs.toArray(new String[lgs.size()]));
    }
    return builder.build();
  }

  public ERegistryConfig registryconfig(Kv kv, String key) {
    ERegistryConfig.Builder builder = new ERegistryConfig.Builder();
    Map map = kv.as(key);
    Object anacs = map.get("AllowNondistributableArtifactsCIDRs");
    if (anacs instanceof List) {
      List ans = (List) anacs;
      builder.allownondistributableartifactscidrs((String[]) ans.toArray(new String[ans.size()]));
    }
    Object anahs = map.get("AllowNondistributableArtifactsHostnames");
    if (anahs instanceof List) {
      List ahs = (List) anahs;
      builder.allownondistributableartifactshostnames((String[]) ahs.toArray(new String[ahs.size()]));
    }
    Object ircs = map.get("InsecureRegistryCIDRs");
    if (ircs instanceof List) {
      List lcs = (List) ircs;
      builder.insecureregistrycidrs((String[]) lcs.toArray(new String[lcs.size()]));
    }
    Object mirrors = map.get("Mirrors");
    if (mirrors instanceof List) {
      List mrs = (List) mirrors;
      builder.mirrors((String[]) mrs.toArray(new String[mrs.size()]));
    }
    Object icfs = map.get("IndexConfigs");
    if (icfs instanceof Map) {
      Map icfg = (Map) icfs;
      Map<String, EIndex> eix = new LinkedHashMap<>();
      icfg.forEach((k, v) -> {
        if (!(v instanceof Map)) {
          return;
        }
        Kv mv = Kv.by((Map) v);
        List mrs = Collections.emptyList();
        Object mr1 = mv.get("Mirrors");
        if (mr1 instanceof List) {
          mrs = (List) mr1;
        }
        EIndex ei = new EIndex.Builder()
          .name(mv.string("Name"))
          .secure(mv.bool("Secure"))
          .official(mv.bool("Official"))
          .mirrors((String[]) mrs.toArray(new String[mrs.size()]))
          .build();
        eix.put(ConvertKit.string(k), ei);
      });
      builder.indexconfigs(eix);
    }
    return builder.build();
  }

  private String[] labels(Kv kv) {
    Object labels = kv.get("Labels");
    if (!(labels instanceof List)) {
      return CollectionKit.emptyArray(String.class);
    }
    List lls = (List) labels;
    return (String[]) lls.toArray(new String[lls.size()]);
  }

  private ESwarm swarm(Kv kv) {
    Object swarm = kv.get("Swarm");
    if (!(swarm instanceof Map))
      return null;
    Kv swm = Kv.by((Map) swarm);
    ESwarm.Builder builder = new ESwarm.Builder();
    builder.nodeid(swm.string("NodeID"))
      .nodeaddr(swm.string("NodeAddr"))
      .localnodestate(swm.string("LocalNodeState"))
      .controlavailable(swm.bool("ControlAvailable"))
      .error(swm.string("Error"))
      .remotemanagers(swm.get("RemoteManagers"));
    return builder.build();
  }

  ECommit comment(Kv kv, String key) {
    Object ky = kv.get(key);
    if (!(ky instanceof Map))
      return null;
    Kv _c = Kv.by((Map) ky);
    ECommit.Builder builder = new ECommit.Builder();
    builder.id(_c.string("ID"))
      .expected(_c.string("Expected"));
    return builder.build();
  }

  private String[] securityOptions(Kv kv) {
    Object options = kv.get("SecurityOptions");
    if (!(options instanceof List))
      return CollectionKit.emptyArray(String.class);
    List ops = (List) options;
    return (String[]) ops.toArray(new String[ops.size()]);
  }
}
