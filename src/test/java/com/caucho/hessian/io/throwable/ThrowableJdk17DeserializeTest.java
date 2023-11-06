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
package com.caucho.hessian.io.throwable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.SerializerFactory;
import com.caucho.hessian.io.throwable.adapter.EnumConstantNotPresentExceptionSerializer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author junyuan
 * @version ThrowableJdk17DeserializeTest.java, v 0.1 2023年11月06日 15:15 junyuan Exp $
 */
public class ThrowableJdk17DeserializeTest {
    private static SerializerFactory     factory;
    private static ByteArrayOutputStream os;

    @BeforeClass
    public static void setUp() {
        factory = new SerializerFactory();

        os = new ByteArrayOutputStream();
    }

    Throwable t = null;
    {
        t = new EnumConstantNotPresentException(MeaninglessEnum.class, "CIG");
    }

    @Test
    public void test_ser_17_des_8() throws IOException {
        String data = "79,-71,106,97,118,97,46,108,97,110,103,46,69,110,117,109,67,111,110,115,116,97,110,116,78,111,116,80,114,101,115,101,110,116,69,120,99,101,112,116,105,111,110,-106,8,101,110,117,109,84,121,112,101,12,99,111,110,115,116,97,110,116,78,97,109,101,13,100,101,116,97,105,108,77,101,115,115,97,103,101,5,99,97,117,115,101,10,115,116,97,99,107,84,114,97,99,101,20,115,117,112,112,114,101,115,115,101,100,69,120,99,101,112,116,105,111,110,115,111,-112,79,-97,106,97,118,97,46,108,97,110,103,46,67,108,97,115,115,-111,4,110,97,109,101,111,-111,83,0,47,99,111,109,46,99,97,117,99,104,111,46,104,101,115,115,105,97,110,46,105,111,46,116,104,114,111,119,97,98,108,101,46,77,101,97,110,105,110,103,108,101,115,115,69,110,117,109,3,67,73,71,83,0,51,99,111,109,46,99,97,117,99,104,111,46,104,101,115,115,105,97,110,46,105,111,46,116,104,114,111,119,97,98,108,101,46,77,101,97,110,105,110,103,108,101,115,115,69,110,117,109,46,67,73,71,78,86,116,0,28,91,106,97,118,97,46,108,97,110,103,46,83,116,97,99,107,84,114,97,99,101,69,108,101,109,101,110,116,110,28,79,-85,106,97,118,97,46,108,97,110,103,46,83,116,97,99,107,84,114,97,99,101,69,108,101,109,101,110,116,-105,15,99,108,97,115,115,76,111,97,100,101,114,78,97,109,101,10,109,111,100,117,108,101,78,97,109,101,13,109,111,100,117,108,101,86,101,114,115,105,111,110,14,100,101,99,108,97,114,105,110,103,67,108,97,115,115,10,109,101,116,104,111,100,78,97,109,101,8,102,105,108,101,78,97,109,101,10,108,105,110,101,78,117,109,98,101,114,111,-110,3,97,112,112,78,78,83,0,59,99,111,109,46,99,97,117,99,104,111,46,104,101,115,115,105,97,110,46,105,111,46,116,104,114,111,119,97,98,108,101,46,83,101,114,105,97,108,105,122,101,67,111,109,112,97,116,105,98,108,101,83,101,108,102,84,101,115,116,6,60,105,110,105,116,62,83,0,32,83,101,114,105,97,108,105,122,101,67,111,109,112,97,116,105,98,108,101,83,101,108,102,84,101,115,116,46,106,97,118,97,-56,62,111,-110,78,9,106,97,118,97,46,98,97,115,101,6,49,55,46,48,46,54,83,0,50,106,100,107,46,105,110,116,101,114,110,97,108,46,114,101,102,108,101,99,116,46,78,97,116,105,118,101,67,111,110,115,116,114,117,99,116,111,114,65,99,99,101,115,115,111,114,73,109,112,108,12,110,101,119,73,110,115,116,97,110,99,101,48,83,0,34,78,97,116,105,118,101,67,111,110,115,116,114,117,99,116,111,114,65,99,99,101,115,115,111,114,73,109,112,108,46,106,97,118,97,-114,111,-110,78,9,106,97,118,97,46,98,97,115,101,6,49,55,46,48,46,54,83,0,50,106,100,107,46,105,110,116,101,114,110,97,108,46,114,101,102,108,101,99,116,46,78,97,116,105,118,101,67,111,110,115,116,114,117,99,116,111,114,65,99,99,101,115,115,111,114,73,109,112,108,11,110,101,119,73,110,115,116,97,110,99,101,83,0,34,78,97,116,105,118,101,67,111,110,115,116,114,117,99,116,111,114,65,99,99,101,115,115,111,114,73,109,112,108,46,106,97,118,97,-56,77,111,-110,78,9,106,97,118,97,46,98,97,115,101,6,49,55,46,48,46,54,83,0,54,106,100,107,46,105,110,116,101,114,110,97,108,46,114,101,102,108,101,99,116,46,68,101,108,101,103,97,116,105,110,103,67,111,110,115,116,114,117,99,116,111,114,65,99,99,101,115,115,111,114,73,109,112,108,11,110,101,119,73,110,115,116,97,110,99,101,83,0,38,68,101,108,101,103,97,116,105,110,103,67,111,110,115,116,114,117,99,116,111,114,65,99,99,101,115,115,111,114,73,109,112,108,46,106,97,118,97,-67,111,-110,78,9,106,97,118,97,46,98,97,115,101,6,49,55,46,48,46,54,29,106,97,118,97,46,108,97,110,103,46,114,101,102,108,101,99,116,46,67,111,110,115,116,114,117,99,116,111,114,21,110,101,119,73,110,115,116,97,110,99,101,87,105,116,104,67,97,108,108,101,114,16,67,111,110,115,116,114,117,99,116,111,114,46,106,97,118,97,-55,-13,111,-110,78,9,106,97,118,97,46,98,97,115,101,6,49,55,46,48,46,54,29,106,97,118,97,46,108,97,110,103,46,114,101,102,108,101,99,116,46,67,111,110,115,116,114,117,99,116,111,114,11,110,101,119,73,110,115,116,97,110,99,101,16,67,111,110,115,116,114,117,99,116,111,114,46,106,97,118,97,-55,-32,111,-110,3,97,112,112,78,78,83,0,40,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,10,99,114,101,97,116,101,84,101,115,116,27,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,46,106,97,118,97,-56,-6,111,-110,3,97,112,112,78,78,83,0,40,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,10,99,114,101,97,116,101,84,101,115,116,27,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,46,106,97,118,97,-55,4,111,-110,3,97,112,112,78,78,83,0,42,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,36,50,17,114,117,110,82,101,102,108,101,99,116,105,118,101,67,97,108,108,27,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,46,106,97,118,97,-55,53,111,-110,3,97,112,112,78,78,83,0,51,111,114,103,46,106,117,110,105,116,46,105,110,116,101,114,110,97,108,46,114,117,110,110,101,114,115,46,109,111,100,101,108,46,82,101,102,108,101,99,116,105,118,101,67,97,108,108,97,98,108,101,3,114,117,110,23,82,101,102,108,101,99,116,105,118,101,67,97,108,108,97,98,108,101,46,106,97,118,97,-100,111,-110,3,97,112,112,78,78,83,0,40,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,11,109,101,116,104,111,100,66,108,111,99,107,27,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,46,106,97,118,97,-55,50,111,-110,3,97,112,112,78,78,83,0,42,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,36,49,8,101,118,97,108,117,97,116,101,27,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,46,106,97,118,97,-56,100,111,-110,3,97,112,112,78,78,30,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,80,97,114,101,110,116,82,117,110,110,101,114,7,114,117,110,76,101,97,102,17,80,97,114,101,110,116,82,117,110,110,101,114,46,106,97,118,97,-55,110,111,-110,3,97,112,112,78,78,83,0,40,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,8,114,117,110,67,104,105,108,100,27,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,46,106,97,118,97,-56,103,111,-110,3,97,112,112,78,78,83,0,40,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,8,114,117,110,67,104,105,108,100,27,66,108,111,99,107,74,85,110,105,116,52,67,108,97,115,115,82,117,110,110,101,114,46,106,97,118,97,-56,63,111,-110,3,97,112,112,78,78,83,0,32,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,80,97,114,101,110,116,82,117,110,110,101,114,36,52,3,114,117,110,17,80,97,114,101,110,116,82,117,110,110,101,114,46,106,97,118,97,-55,75,111,-110,3,97,112,112,78,78,83,0,32,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,80,97,114,101,110,116,82,117,110,110,101,114,36,49,8,115,99,104,101,100,117,108,101,17,80,97,114,101,110,116,82,117,110,110,101,114,46,106,97,118,97,-56,79,111,-110,3,97,112,112,78,78,30,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,80,97,114,101,110,116,82,117,110,110,101,114,11,114,117,110,67,104,105,108,100,114,101,110,17,80,97,114,101,110,116,82,117,110,110,101,114,46,106,97,118,97,-55,73,111,-110,3,97,112,112,78,78,30,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,80,97,114,101,110,116,82,117,110,110,101,114,10,97,99,99,101,115,115,36,49,48,48,17,80,97,114,101,110,116,82,117,110,110,101,114,46,106,97,118,97,-56,66,111,-110,3,97,112,112,78,78,83,0,32,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,80,97,114,101,110,116,82,117,110,110,101,114,36,50,8,101,118,97,108,117,97,116,101,17,80,97,114,101,110,116,82,117,110,110,101,114,46,106,97,118,97,-55,37,111,-110,3,97,112,112,78,78,83,0,48,111,114,103,46,106,117,110,105,116,46,105,110,116,101,114,110,97,108,46,114,117,110,110,101,114,115,46,115,116,97,116,101,109,101,110,116,115,46,82,117,110,66,101,102,111,114,101,115,8,101,118,97,108,117,97,116,101,15,82,117,110,66,101,102,111,114,101,115,46,106,97,118,97,-86,111,-110,3,97,112,112,78,78,83,0,32,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,80,97,114,101,110,116,82,117,110,110,101,114,36,51,8,101,118,97,108,117,97,116,101,17,80,97,114,101,110,116,82,117,110,110,101,114,46,106,97,118,97,-55,50,111,-110,3,97,112,112,78,78,30,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,115,46,80,97,114,101,110,116,82,117,110,110,101,114,3,114,117,110,17,80,97,114,101,110,116,82,117,110,110,101,114,46,106,97,118,97,-55,-99,111,-110,3,97,112,112,78,78,26,111,114,103,46,106,117,110,105,116,46,114,117,110,110,101,114,46,74,85,110,105,116,67,111,114,101,3,114,117,110,14,74,85,110,105,116,67,111,114,101,46,106,97,118,97,-56,-119,111,-110,3,97,112,112,78,78,83,0,40,99,111,109,46,105,110,116,101,108,108,105,106,46,106,117,110,105,116,52,46,74,85,110,105,116,52,73,100,101,97,84,101,115,116,82,117,110,110,101,114,19,115,116,97,114,116,82,117,110,110,101,114,87,105,116,104,65,114,103,115,25,74,85,110,105,116,52,73,100,101,97,84,101,115,116,82,117,110,110,101,114,46,106,97,118,97,-56,69,111,-110,3,97,112,112,78,78,83,0,45,99,111,109,46,105,110,116,101,108,108,105,106,46,114,116,46,106,117,110,105,116,46,73,100,101,97,84,101,115,116,82,117,110,110,101,114,36,82,101,112,101,97,116,101,114,19,115,116,97,114,116,82,117,110,110,101,114,87,105,116,104,65,114,103,115,19,73,100,101,97,84,101,115,116,82,117,110,110,101,114,46,106,97,118,97,-79,111,-110,3,97,112,112,78,78,83,0,34,99,111,109,46,105,110,116,101,108,108,105,106,46,114,116,46,106,117,110,105,116,46,74,85,110,105,116,83,116,97,114,116,101,114,22,112,114,101,112,97,114,101,83,116,114,101,97,109,115,65,110,100,83,116,97,114,116,17,74,85,110,105,116,83,116,97,114,116,101,114,46,106,97,118,97,-56,-35,111,-110,3,97,112,112,78,78,83,0,34,99,111,109,46,105,110,116,101,108,108,105,106,46,114,116,46,106,117,110,105,116,46,74,85,110,105,116,83,116,97,114,116,101,114,4,109,97,105,110,17,74,85,110,105,116,83,116,97,114,116,101,114,46,106,97,118,97,-56,54,122,86,116,0,50,106,97,118,97,46,117,116,105,108,46,67,111,108,108,101,99,116,105,111,110,115,36,85,110,109,111,100,105,102,105,97,98,108,101,82,97,110,100,111,109,65,99,99,101,115,115,76,105,115,116,110,0,122";
        byte[] input = convertStringToByteArray(data);

        Object result = doDecode(input, factory);

        // 数据来自另一个项目, 无法保证 stack trace 也完全一致
        // 只能根据数据源特征做一些判断
        Assert.assertTrue(result instanceof EnumConstantNotPresentException);
        EnumConstantNotPresentException e = (EnumConstantNotPresentException) result;
        Assert.assertEquals(28, e.getStackTrace().length);
        Assert.assertEquals("CIG", e.constantName());
    }

    private byte[] convertStringToByteArray(String str) {
        String[] strArray = str.split(",");
        byte[] byteArray = new byte[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            byteArray[i] = Byte.parseByte(strArray[i]);
        }

        return byteArray;

    }

    protected Object doDecode(byte[] data, SerializerFactory factory) throws IOException {
        os.reset();
        ByteArrayInputStream is = new ByteArrayInputStream(data);
        Hessian2Input input = new Hessian2Input(is);
        input.setSerializerFactory(factory);
        return input.readObject();
    }
}