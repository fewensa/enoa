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
package io.enoa.toolkit.bean.reduction;

import io.enoa.toolkit.bean.Bonfig;

import java.lang.reflect.Type;
import java.util.Map;

class MapReduction {

  private static class Holder {
    private static final MapReduction INSTANCE = new MapReduction();
  }

  static MapReduction instance() {
    return Holder.INSTANCE;
  }

  <T> T object(Map<String, Object> map, Type type, int depth, Bonfig config) {
    return null;
  }

}