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
package io.enoa.json;

import io.enoa.json.provider.enoa.EoJsonProvider;

public class EPMJson {

  private EPMJson() {

  }

  private static class Holder {
    private static final EPMJson INSTANCE = new EPMJson();
  }

  static EPMJson instance() {
    return Holder.INSTANCE;
  }

  private EoJsonFactory defJsonFactory = new EoJsonProvider();

  public void install(EoJsonFactory factory) {
    this.defJsonFactory = factory;
  }

  public EoJsonFactory factory() {
    return defJsonFactory;
  }

  public EnoaJson json() {
    return this.defJsonFactory.json();
  }

}
