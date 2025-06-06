/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.fory.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.fory.memory.MemoryBuffer;
import org.apache.fory.util.Preconditions;

/** InputStream based on {@link MemoryBuffer}. */
public class MemoryBufferInputStream extends InputStream {
  private final MemoryBuffer buffer;

  public MemoryBufferInputStream(MemoryBuffer buffer) {
    this.buffer = buffer;
  }

  public int read() {
    if (buffer.remaining() == 0) {
      return -1;
    } else {
      return buffer.readByte() & 0xFF;
    }
  }

  public int read(byte[] bytes, int offset, int length) throws IOException {
    if (length == 0) {
      return 0;
    }
    int size = Math.min(buffer.remaining(), length);
    if (size == 0) {
      return -1;
    }
    buffer.readBytes(bytes, offset, size);
    return size;
  }

  @Override
  public long skip(long n) throws IOException {
    Preconditions.checkArgument(n < Integer.MAX_VALUE);
    int nbytes = (int) Math.min(n, buffer.remaining());
    buffer.increaseReaderIndex(nbytes);
    return nbytes;
  }

  public int available() throws IOException {
    return buffer.remaining();
  }
}
