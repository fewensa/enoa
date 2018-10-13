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
package io.enoa.docker.dret.container;

import io.enoa.docker.dret.AbstractDRet;

public class ECNetwork extends AbstractDRet {


  private final EBridge bridge;

  public ECNetwork(Builder builder) {
    this.bridge = builder.bridge;
  }

  public EBridge bridge() {
    return this.bridge;
  }

  public static class Builder {
    private EBridge bridge;

    public ECNetwork build() {
      return new ECNetwork(this);
    }

    public Builder bridge(EBridge bridge) {
      this.bridge = bridge;
      return this;
    }
  }
}
