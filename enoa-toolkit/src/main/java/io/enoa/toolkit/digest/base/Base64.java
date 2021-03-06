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
package io.enoa.toolkit.digest.base;

import io.enoa.toolkit.EoConst;
import io.enoa.toolkit.binary.EnoaBinary;

import java.nio.charset.Charset;

final class Base64 {

  private static IBase64 DELEGATE;

  private Base64() {
  }

  static {
    if (isPresent("java.util.Base64", Base64.class.getClassLoader())) {
      DELEGATE = new Java8Base64();
    } else {
      DELEGATE = new Java67Base64();
    }
  }

  public enum Mode {
    GENERALLY,
    URLSAFE
  }


  /**
   * 编码
   *
   * @param value byte数组
   * @param mode  模式
   * @return {String}
   */
  public static String encode(Mode mode, byte[] value) {
    String _v = DELEGATE.encode(value);
    if (mode == Mode.GENERALLY)
      return _v;
    _v = _v.replace('+', '-');
    _v = _v.replace('/', '_');
    _v = _v.replace("=", "");
    return _v;
  }

  /**
   * 编码
   *
   * @param value 字符串
   * @param mode  模式
   * @return {String}
   */
  public static String encode(Mode mode, String value) {
    return encode(mode, value, EoConst.CHARSET);
  }

  /**
   * 编码
   *
   * @param value   字符串
   * @param mode    模式
   * @param charset charset
   * @return {String}
   */
  public static String encode(Mode mode, String value, Charset charset) {
    byte[] val = value.getBytes(charset);
    return encode(mode, val);
  }

  /**
   * 编码
   *
   * @param value byte数组
   * @return {String}
   */
  public static String encode(byte[] value) {
    return encode(Mode.GENERALLY, value);
  }

  /**
   * 编码
   *
   * @param value 字符串
   * @return {String}
   */
  public static String encode(String value) {
    return encode(Mode.GENERALLY, value);
  }

  /**
   * 编码
   *
   * @param value   字符串
   * @param charset charset
   * @return {String}
   */
  public static String encode(String value, Charset charset) {
    byte[] val = value.getBytes(charset);
    return encode(Mode.GENERALLY, val);
  }

  /**
   * 解码
   *
   * @param mode  模式
   * @param value 字符串
   * @return {byte[]}
   */
  public static EnoaBinary decode(Mode mode, String value) {
    return decode(mode, value, EoConst.CHARSET);
  }

  public static EnoaBinary decode(Mode mode, String value, Charset charset) {
    EnoaBinary binary = EnoaBinary.create(DELEGATE.decode(value), charset);
    if (mode != Mode.URLSAFE)
      return binary;
    String _v = binary.string();
    _v = _v.replace('-', '+');
    _v = _v.replace('_', '/');
    int mod4 = _v.length() % 4;
    if (mod4 > 0) {
      _v = _v + "====".substring(mod4);
    }
    return EnoaBinary.create(_v.getBytes(charset), charset);
  }

  public static EnoaBinary decode(String value) {
    return decode(Mode.GENERALLY, value, EoConst.CHARSET);
  }

  public static EnoaBinary decode(String value, Charset charset) {
    return decode(Mode.GENERALLY, value, charset);
  }

  private static boolean isPresent(String className, ClassLoader classLoader) {
    try {
      Class.forName(className, true, classLoader);
      return true;
    } catch (Throwable ex) {
      return false;
    }
  }

  private interface IBase64 {
    String encode(byte[] value);

    byte[] decode(String value);
  }

  private static class Java8Base64 implements IBase64 {
    @Override
    public String encode(byte[] value) {
      return java.util.Base64.getEncoder().encodeToString(value);
    }

    @Override
    public byte[] decode(String value) {
      return java.util.Base64.getDecoder().decode(value);
    }
  }

  private static class Java67Base64 implements IBase64 {
    @Override
    public String encode(byte[] data) {
      return javax.xml.bind.DatatypeConverter.printBase64Binary(data);
    }

    @Override
    public byte[] decode(String base64) {
      return javax.xml.bind.DatatypeConverter.parseBase64Binary(base64);
    }
  }
}
