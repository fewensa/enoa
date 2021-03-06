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
package io.enoa.docker.dket.docker.common;

import io.enoa.docker.dket.AbstractDRRet;

public class ETLSInfo extends AbstractDRRet {
  private final String trustroot;
  private final String certissuersubject;
  private final String certissuerpublickey;


  public ETLSInfo(Builder builder) {
    this.trustroot = builder.trustroot;
    this.certissuersubject = builder.certissuersubject;
    this.certissuerpublickey = builder.certissuerpublickey;
  }

  public String trustroot() {
    return this.trustroot;
  }

  public String certissuersubject() {
    return this.certissuersubject;
  }

  public String certissuerpublickey() {
    return this.certissuerpublickey;
  }

  public static class Builder {

    private String trustroot;
    private String certissuersubject;
    private String certissuerpublickey;

    public ETLSInfo build() {
      return new ETLSInfo(this);
    }

    public Builder trustroot(String trustroot) {
      this.trustroot = trustroot;
      return this;
    }

    public Builder certissuersubject(String certissuersubject) {
      this.certissuersubject = certissuersubject;
      return this;
    }

    public Builder certissuerpublickey(String certissuerpublickey) {
      this.certissuerpublickey = certissuerpublickey;
      return this;
    }
  }
}
