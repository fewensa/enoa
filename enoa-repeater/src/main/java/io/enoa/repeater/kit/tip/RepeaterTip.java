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
package io.enoa.repeater.kit.tip;

import io.enoa.log.Log;
import io.enoa.repeater.Repeater;
import io.enoa.toolkit.collection.CollectionKit;
import io.enoa.toolkit.text.TextKit;

import java.text.MessageFormat;
import java.util.stream.Stream;

public class RepeaterTip {

  private RepeaterTip() {
  }


  private static String format(String text, Object... args) {
    if (TextKit.blanky(text))
      return text;
    if (CollectionKit.isEmpty(args))
      return text;
    Object[] fags = Stream.of(args).map(o -> o == null ? null : o.toString()).toArray(Object[]::new);
    return MessageFormat.format(text, fags);
  }

  public static void message(String text, Object... args) {
    if (!Repeater.config().info())
      return;
    if (Repeater.config().infoUseLog()) {
      Log.debug(format(text, args));
      return;
    }
    System.out.println(format(text, args));
  }

}
