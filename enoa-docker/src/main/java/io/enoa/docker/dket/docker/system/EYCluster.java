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
package io.enoa.docker.dket.docker.system;

import io.enoa.docker.dket.AbstractDRRet;
import io.enoa.docker.dket.docker.common.ETLSInfo;
import io.enoa.docker.dket.docker.swarm.ESwarmSpec;
import io.enoa.docker.dket.docker.swarm.EVersion;

import java.util.Date;

public class EYCluster extends AbstractDRRet {

  private String id;
  private EVersion version;
  private Date createdat;
  private Date updatedat;
  private ESwarmSpec spec;
  private ETLSInfo tlsinfo;
  private Boolean rootrotationinprogress;

  public EYCluster(Builder builder) {
    this.id = builder.id;
    this.version = builder.version;
    this.createdat = builder.createdat;
    this.updatedat = builder.updatedat;
    this.spec = builder.spec;
    this.tlsinfo = builder.tlsinfo;
    this.rootrotationinprogress = builder.rootrotationinprogress;
  }

  public String id() {
    return this.id;
  }

  public EVersion version() {
    return this.version;
  }

  public Date createdat() {
    return this.createdat;
  }

  public Date updatedat() {
    return this.updatedat;
  }

  public ESwarmSpec spec() {
    return this.spec;
  }

  public ETLSInfo tlsinfo() {
    return this.tlsinfo;
  }

  public Boolean rootrotationinprogress() {
    return this.rootrotationinprogress;
  }

  public static class Builder {
    private String id;
    private EVersion version;
    private Date createdat;
    private Date updatedat;
    private ESwarmSpec spec;
    private ETLSInfo tlsinfo;
    private Boolean rootrotationinprogress;

    public EYCluster build() {
      return new EYCluster(this);
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder version(EVersion version) {
      this.version = version;
      return this;
    }

    public Builder createdat(Date createdat) {
      this.createdat = createdat;
      return this;
    }

    public Builder updatedat(Date updatedat) {
      this.updatedat = updatedat;
      return this;
    }

    public Builder spec(ESwarmSpec spec) {
      this.spec = spec;
      return this;
    }

    public Builder tlsinfo(ETLSInfo tlsinfo) {
      this.tlsinfo = tlsinfo;
      return this;
    }

    public Builder rootrotationinprogress(Boolean rootrotationinprogress) {
      this.rootrotationinprogress = rootrotationinprogress;
      return this;
    }
  }


}
