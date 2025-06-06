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

package org.apache.fory.resolver;

import org.apache.fory.serializer.Serializer;

/** A helper class for holding and update {@link ClassInfo} to reduce map look-up. */
@SuppressWarnings("rawtypes")
public class ClassInfoHolder {
  public ClassInfo classInfo;

  public ClassInfoHolder(ClassInfo classInfo) {
    this.classInfo = classInfo;
  }

  public Serializer getSerializer() {
    return classInfo.serializer;
  }

  @Override
  public String toString() {
    return "Holder{" + classInfo + '}';
  }
}
