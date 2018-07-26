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
package io.enoa.tryjson.eson.converter;

import io.enoa.tryjson.Tsonfig;

import java.util.Date;
import java.util.Map;

public interface EsonConverter<T> {

  static EsonConverter<String> string() {
    return _StringConverter.instance();
  }

  static EsonConverter<Boolean> bool() {
    return _BoolConverter.instance();
  }

  static EsonConverter<Number> number() {
    return _NumberConverter.instance();
  }

  static EsonConverter<Date> date() {
    return _DateConverter.instance();
  }

  static EsonConverter<Iterable> iterable() {
    return _IterableConverter.instance();
  }

  static EsonConverter<Map> map() {
    return _MapConverter.instance();
  }

  static EsonConverter<Object> object() {
    return _ObjectConverter.instance();
  }

  static EsonConverter<Enum> enumx() {
    return _EnumConverter.instance();
  }

  String json(T object, int depth, Tsonfig conf);

}
