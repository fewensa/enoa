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
package io.enoa.toolkit;

import io.enoa.toolkit.sys.EnvKit;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * enoa - io.enoa.toolkit
 */
public interface EoConst {

  Charset CHARSET = StandardCharsets.UTF_8;

  /**
   * os charset
   */
  Charset _CHARSET_OS = Charset.forName(EnvKit.string("sun.jnu.encoding"));

  String DEF_FORMAT_DATE = "yyyy-MM-dd HH:mm:ss.SSS";

  /**
   * restful uri 识别符号
   */
  String RESTFUL_RECOGNIZE = ":";

}
