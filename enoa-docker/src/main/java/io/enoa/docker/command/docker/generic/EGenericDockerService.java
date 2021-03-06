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
package io.enoa.docker.command.docker.generic;

import io.enoa.docker.DockerConfig;
import io.enoa.docker.command.docker.origin.EOriginDockerService;
import io.enoa.docker.command.docker.origin.OriginDocker;
import io.enoa.docker.dqp.common.DQPFilter;
import io.enoa.docker.dqp.docker.service.DQPServiceCreate;
import io.enoa.docker.dqp.docker.service.DQPServiceUpdate;
import io.enoa.docker.parser.docker.DIParser;
import io.enoa.docker.dket.docker.DResp;
import io.enoa.docker.dket.docker.DRet;
import io.enoa.docker.dket.docker.service.DQPServiceLogs;
import io.enoa.toolkit.value.Void;

import java.util.List;

public class EGenericDockerService {

  private OriginDocker docker;
  private DockerConfig config;
  private EOriginDockerService services;


  EGenericDockerService(OriginDocker docker) {
    this.docker = docker;
    this.config = docker._dockerconfig();
    this.services = docker.service();
  }

  public <T> DRet<List<T>> list(DIParser<List<T>> parser) {
    return this.list(parser, null);
  }

  public <T> DRet<List<T>> list(DIParser<List<T>> parser, DQPFilter dqp) {
    DResp resp = this.services.list(dqp);
    return parser.parse(this.config, resp);
  }

  public <T> DRet<T> create(DIParser<T> parser, String body) {
    return this.create(parser, body, null);
  }

  public <T> DRet<T> create(DIParser<T> parser, String body, DQPServiceCreate dqp) {
    DResp resp = this.services.create(body, dqp);
    return parser.parse(this.config, resp);
  }

  public <T> DRet<T> inspect(DIParser<T> parser, String id) {
    return this.inspect(parser, id, Boolean.FALSE);
  }

  public <T> DRet<T> inspect(DIParser<T> parser, String id, boolean insertDefaults) {
    DResp resp = this.services.inspect(id, insertDefaults);
    return parser.parse(this.config, resp);
  }

  public DRet<Void> remove(String id) {
    DResp resp = this.services.remove(id);
    return DIParser.voidx().parse(this.config, resp);
  }

  public <T> DRet<T> update(DIParser<T> parser, String id, String body, DQPServiceUpdate dqp) {
    DResp resp = this.services.update(id, body, dqp);
    return parser.parse(this.config, resp);
  }

  public <T> DRet<T> logs(DIParser<T> parser, String id) {
    return this.logs(parser, id, null);
  }

  public <T> DRet<T> logs(DIParser<T> parser, String id, DQPServiceLogs dqp) {
    DResp resp = this.services.logs(id, dqp);
    return parser.parse(this.config, resp);
  }

}
