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
package io.enoa.yosart.resp;

import io.enoa.repeater.http.Cookie;
import io.enoa.repeater.http.Header;
import io.enoa.repeater.http.HttpStatus;
import io.enoa.repeater.http.Request;

public interface Resp extends Renderer {


  static Resp with(Request req) {
    return new RespImpl(req);
  }

  Resp stat(HttpStatus stat);

  Resp cookie(Cookie cookie);

  Resp header(Header header);


}
