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
package io.enoa.shell.ret;

import io.enoa.toolkit.EoConst;
import io.enoa.toolkit.binary.EnoaBinary;
import io.enoa.toolkit.digest.DigestKit;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public abstract class ShellResult implements Serializable {

  public abstract String[] commands();

  public abstract int exitvalue();

  public abstract Charset charset();

  public abstract byte[] bytes();

  public ByteBuffer bytebuffer() {
    return this.binary().bytebuffer();
  }

  public EnoaBinary binary() {
    return this.binary(this.charset());
  }

  public EnoaBinary binary(Charset charset) {
    return EnoaBinary.create(this.bytes(), charset);
  }

  public String string() {
    return this.binary().string();
  }

  public String string(Charset charset) {
    return this.binary(charset).string();
  }

  public static ShellResult create(String[] commands, int exitvalue, byte[] bytes) {
    return create(commands, exitvalue, bytes, EoConst.CHARSET);
  }

  public static ShellResult create(String[] commands, int exitvalue, byte[] bytes, Charset charset) {
    return new ShellResult() {
      @Override
      public String[] commands() {
        return commands;
      }

      @Override
      public int exitvalue() {
        return exitvalue;
      }

      @Override
      public Charset charset() {
        return charset;
      }

      @Override
      public byte[] bytes() {
        return bytes;
      }
    };
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.bytes());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    ShellResult that = (ShellResult) obj;
    return DigestKit.slowEquals(this.bytes(), that.bytes());
  }

  @Override
  public String toString() {
    return Arrays.toString(this.bytes());
  }
}
