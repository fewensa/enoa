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
package io.enoa.http.provider.httphelper;

import io.enoa.http.EoHttp;
import io.enoa.http.Http;

public class HttpHelperProvider implements EoHttp {

  private static class Holder {
    private static final HttpHelperProvider INSTANCE = new HttpHelperProvider();
  }

  private HttpHelperProvider() {

  }

  public static HttpHelperProvider instance() {
    return Holder.INSTANCE;
  }

  @Override
  public Http http() {
    return new _HttpHelper();
  }
}
