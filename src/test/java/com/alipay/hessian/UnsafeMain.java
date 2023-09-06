/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.hessian;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author junyuan
 * @version UnsafeMain.java, v 0.1 2023年05月09日 16:22 junyuan Exp $
 */
public class UnsafeMain {

    private static Unsafe _unsafe;
    static {
        try {
            Class<?> unsafe = Class.forName("sun.misc.Unsafe");
            Field theUnsafe = null;
            for (Field field : unsafe.getDeclaredFields()) {
                if (field.getName().equals("theUnsafe"))
                    theUnsafe = field;
            }

            if (theUnsafe != null) {
                theUnsafe.setAccessible(true);
                _unsafe = (Unsafe) theUnsafe.get(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        AtomicInteger i = new AtomicInteger(7);

        Field value = AtomicInteger.class.getField("value");
        try {
            value.set(i, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            value.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long offset = _unsafe.objectFieldOffset(value);

    }
}