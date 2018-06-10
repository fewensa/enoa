/*
 * Copyright (c) 2018, enoa (ein.windmill@outlook.com)
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
package io.enoa.index.solr;

import io.enoa.http.EoHttp;
import io.enoa.http.Http;
import io.enoa.index.solr.action.SolrUpdate;
import io.enoa.index.solr.action.select.SolrSelect;
import io.enoa.toolkit.eo.tip.EnoaTipKit;

class EnoaSolrImpl implements EoSolr {

  private SolrConfig config;
  private String core;
  private Http http;

  EnoaSolrImpl(SolrConfig config) {
    this.config = config;
  }

  @Override
  public EoSolr http(EoHttp http) {
    this.http = http.http();
    return this;
  }

  @Override
  public Http http() {
    if (this.http == null)
      this.http = Http.request();
    return this.http;
  }

  @Override
  public EoSolr core(String core) {
    this.core = core;
    return this;
  }

  @Override
  public SolrSelect select() {
    if (this.core == null)
      throw new IllegalArgumentException(EnoaTipKit.message("eo.tip.solr.core_null"));
    return new SolrSelect(this.http(), this.config, this.core);
  }

  @Override
  public SolrUpdate update() {
    if (this.core == null)
      throw new IllegalArgumentException(EnoaTipKit.message("eo.tip.solr.core_null"));
    return new SolrUpdate(this.http(), this.config, this.core);
  }

}