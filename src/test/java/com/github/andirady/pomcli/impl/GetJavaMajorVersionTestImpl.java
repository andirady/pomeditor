/**
 * Copyright 2021-2024 Andi Rady Kurniawan
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.andirady.pomcli.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.github.andirady.pomcli.GetJavaMajorVersion;

public class GetJavaMajorVersionTestImpl implements GetJavaMajorVersion {

    private static ThreadLocal<String> result = new ThreadLocal<>();

    public void setResult(String value) {
        result.set(value);
    }

    @Override
    public BufferedReader getBufferedReader() throws IOException {
        if (result.get() == null) {
            return new GetJavaMajorVersionImpl().getBufferedReader();
        }

        var baos = new ByteArrayInputStream(result.get().getBytes());
        return new BufferedReader(new InputStreamReader(baos));
    }
    
}
