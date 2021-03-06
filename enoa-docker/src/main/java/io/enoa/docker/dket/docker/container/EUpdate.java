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
package io.enoa.docker.dket.docker.container;

import io.enoa.docker.dket.AbstractDRRet;

import java.util.List;

public class EUpdate extends AbstractDRRet {

  private final List<String> warnings;

  public EUpdate(Builder builder) {
    this.warnings = builder.warnings;
  }

  public List<String> warnings() {
    return warnings;
  }

  public static class Builder {
    private List<String> warnings;

    public EUpdate build() {
      return new EUpdate(this);
    }

    public Builder warnings(List<String> warnings) {
      this.warnings = warnings;
      return this;
    }
  }

}
