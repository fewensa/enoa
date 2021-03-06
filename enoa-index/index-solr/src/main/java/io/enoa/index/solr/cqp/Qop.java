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
package io.enoa.index.solr.cqp;

import io.enoa.toolkit.mark.IMarkVal;

public enum Qop implements IMarkVal {


  AND("and"),

  OR("or"),
  //
  ;

  private String val;

  Qop(String val) {
    this.val = val;
  }


  @Override
  public String val() {
    return this.val;
  }

  public static Qop of(String op) {
    if (op == null)
      return null;
    for (Qop _q : Qop.values()) {
      if (_q.val.equalsIgnoreCase(op))
        return _q;
    }
    return null;
  }
}
