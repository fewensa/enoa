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
import io.enoa.toolkit.map.Kv;

public class EActor extends AbstractDRRet {

  private String id;
  private Kv attributes;

  public EActor(Builder builder) {
    this.id = builder.id;
    this.attributes = builder.attributes;
  }

  public String id() {
    return this.id;
  }

  public Kv attributes() {
    return this.attributes;
  }

  public static class Builder {

    private String id;
    private Kv attributes;

    public EActor build() {
      return new EActor(this);
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder attributes(Kv attributes) {
      this.attributes = attributes;
      return this;
    }
  }

}
