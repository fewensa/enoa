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
package io.enoa.ext.sess;

import io.enoa.toolkit.random.RandomKit;
import io.enoa.yosart.kernel.ext.YmSessionExt;
import io.enoa.yosart.kernel.http.Session;
import io.enoa.yosart.kernel.http.YoRequest;

public class SessExt implements YmSessionExt {

  private SessFactory factory;

  private double wight = RandomKit.nextDouble(1, 9);

  public SessExt(SessFactory factory) {
    this.factory = factory;
  }

  @Override
  public Session session(YoRequest request) {
    return this.factory.sess(request);
  }

  @Override
  public String name() {
    return "SessExt";
  }

  @Override
  public String version() {
    return "1";
  }

  @Override
  public double weight() {
    return this.wight;
  }
}
