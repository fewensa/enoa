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
package io.enoa.tryjson.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

abstract class _Ja<E, RET> implements Iterable<E>, Toa {

  Collection<E> collection;

  _Ja() {
    this(new ArrayList<>());
  }

  _Ja(Collection<E> collection) {
    this.collection = collection;
  }

  @Override
  public Iterator<E> iterator() {
    return this.collection.iterator();
  }

  public abstract RET add(E item);

}
