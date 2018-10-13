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

public class EJoinTokens extends AbstractDRet {
  private final String worker;
  private final String manager;

  public EJoinTokens(Builder builder) {
    this.worker = builder.worker;
    this.manager = builder.manager;
  }

  public String worker() {
    return this.worker;
  }

  public String manager() {
    return this.manager;
  }

  public static class Builder {
    private String worker;
    private String manager;

    public EJoinTokens build() {
      return new EJoinTokens(this);
    }

    public Builder worker(String worker) {
      this.worker = worker;
      return this;
    }

    public Builder manager(String manager) {
      this.manager = manager;
      return this;
    }
  }
}
