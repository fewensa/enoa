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
package io.enoa.db.provider.ds.druid;

import io.enoa.db.EnoaDs;
import io.enoa.db.EoDsConfig;
import io.enoa.db.EoDsFactory;

public class DruidProvider implements EoDsFactory {
  @Override
  public EnoaDs datasource(EoDsConfig config) {
    DruidConfig conf = config instanceof DruidConfig ? (DruidConfig) config : new DruidConfig(config);
    return new _Druid(conf);
  }
}
