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
package io.enoa.tryjson;

import io.enoa.toolkit.EoConst;
import io.enoa.toolkit.namecase.INameCase;
import io.enoa.tryjson.converter.IEnumConverter;
import io.enoa.tryjson.format.IJsonFormat;
import io.enoa.tryjson.mark.DateFormatStrategy;

public class Esonfig {

  /**
   * 調試模式
   */
  private final boolean debug;
  /**
   * 時間格式化策略
   */
  private final DateFormatStrategy dateFormatStrategy;
  /**
   * 如果時間格式化策略爲字符串模式, 所選用的時間格式化格式
   */
  private final String dateFormat;
  /**
   * json key 命名轉換規則, 默認不轉換
   */
  private final INameCase namecase;
  /**
   * 枚舉轉換規則, 默認使用枚舉字段名
   */
  private final IEnumConverter enumConverter;
  /**
   * 對象轉換 json 後, 對 json 字符串進行格式化
   */
  private final IJsonFormat jsonFormat;

  private Esonfig(Builder builder) {
    this.debug = builder.debug;
    this.dateFormat = builder.dateFormat;
    this.dateFormatStrategy = builder.dateFormatStrategy;
    this.namecase = builder.namecase;
    this.enumConverter = builder.enumConverter;
    this.jsonFormat = builder.jsonFormat;
  }

  public static Esonfig def() {
    return new Builder().build();
  }

  public boolean debug() {
    return this.debug;
  }

  public String dateFormat() {
    return this.dateFormat;
  }

  public DateFormatStrategy dateFormatStrategy() {
    return this.dateFormatStrategy;
  }

  public INameCase namecase() {
    return this.namecase;
  }

  public IEnumConverter enumConverter() {
    return this.enumConverter;
  }

  public IJsonFormat jsonFormat() {
    return this.jsonFormat;
  }

  public Builder builder() {
    return new Builder(this);
  }

  public static class Builder {
    private boolean debug;
    private DateFormatStrategy dateFormatStrategy;
    private String dateFormat;
    private INameCase namecase;
    private IEnumConverter enumConverter;
    private IJsonFormat jsonFormat;

    public Builder() {
      this.debug = Boolean.FALSE;
      this.dateFormat = EoConst.DEF_FORMAT_DATE;
      this.dateFormatStrategy = DateFormatStrategy.STRING;
      this.namecase = INameCase.def();
      this.enumConverter = IEnumConverter.def();
      this.jsonFormat = IJsonFormat.def();
    }

    private Builder(Esonfig esonfig) {
      this.debug = esonfig.debug;
      this.dateFormat = esonfig.dateFormat;
      this.dateFormatStrategy = esonfig.dateFormatStrategy;
      this.namecase = esonfig.namecase;
      this.enumConverter = esonfig.enumConverter;
      this.jsonFormat = esonfig.jsonFormat;
    }

    public Esonfig build() {
      return new Esonfig(this);
    }

    public Builder debug(boolean debug) {
      this.debug = debug;
      return this;
    }

    public Builder dateFormatStrategy(DateFormatStrategy dateFormatStrategy) {
      this.dateFormatStrategy = dateFormatStrategy;
      return this;
    }

    public Builder dateFormat(String dateFormat) {
      this.dateFormat = dateFormat;
      return this;
    }

    public Builder namecase(INameCase namecase) {
      this.namecase = namecase;
      return this;
    }

    public Builder enumConverter(IEnumConverter enumConverter) {
      this.enumConverter = enumConverter;
      return this;
    }

    public Builder jsonFormat(IJsonFormat jsonFormat) {
      this.jsonFormat = jsonFormat;
      return this;
    }
  }
}