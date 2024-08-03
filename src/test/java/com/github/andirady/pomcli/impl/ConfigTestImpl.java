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

import com.github.andirady.pomcli.Config;

public class ConfigTestImpl implements Config {

    private static ThreadLocal<String> defaultGroupIdTL = new ThreadLocal<>();

    private Config actualImpl = new ConfigImpl();

	public void setDefaultGroupId(String defaultGroupId) {
        defaultGroupIdTL.set(defaultGroupId);
    }

    @Override
    public String getDefaultGroupId() {
        var defaultGroupId = defaultGroupIdTL.get();
        if (defaultGroupId == null) {
            return actualImpl.getDefaultGroupId();
        }

        return defaultGroupId;
    }
}
