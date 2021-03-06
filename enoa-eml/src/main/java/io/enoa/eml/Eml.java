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
package io.enoa.eml;

public interface Eml {

  static EPMEml epm() {
    return EPMEml.instance();
  }

  static Eml provider(Eml provider) {
    return provider;
  }

//  /**
//   * @param sess sess
//   * @return Eml
//   * @deprecated will remove next version 1.7
//   */
//  @Deprecated
//  static Eml with(EoEmlSession sess) {
//    return new EnoaEmlProvider(sess);
//  }

  static Eml use(String name) {
    return epm().eml(name);
  }

  static Eml use() {
    return epm().eml();
  }

  EmlSender sender();

  @Deprecated
  default EmlReceiver receiver() {
    return this.receiver(EmlProtocol.POP3);
  }

  /**
   * 尚未完成
   *
   * @param protocol 协议
   * @return EmlReceiver
   */
  @Deprecated
  EmlReceiver receiver(EmlProtocol protocol);

}
