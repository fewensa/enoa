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
package io.enoa.docker.dret.swarm;

import io.enoa.docker.dret.AbstractDRet;

public class ESwarmUnlockKey extends AbstractDRet {

  private final String unlockkey;

  public ESwarmUnlockKey(Builder builder) {
    this.unlockkey = builder.unlockkey;
  }

  public String unlockkey() {
    return this.unlockkey;
  }

  public static class Builder {
    private String unlockkey;

    public ESwarmUnlockKey build() {
      return new ESwarmUnlockKey(this);
    }

    public Builder unlockkey(String unlockkey) {
      this.unlockkey = unlockkey;
      return this;
    }
  }

}
