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
package io.enoa.docker.dket.dockerhub.explore;

import io.enoa.docker.dket.dockerhub.EHubPage;

import java.util.List;

public class EHExplore extends EHubPage {

  private final List<EHEResult> results;

  public EHExplore(Builder builder) {
    super(builder);
    this.results = builder.results;
  }

  public List<EHEResult> results() {
    return this.results;
  }

  public static class Builder extends EHubPage.Builder<Builder> {

    private List<EHEResult> results;

    @Override
    public EHExplore build() {
      return new EHExplore(this);
    }

    public Builder results(List<EHEResult> results) {
      this.results = results;
      return this;
    }

  }

}
