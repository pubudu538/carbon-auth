/*
 *   Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package org.wso2.carbon.auth.user.info.impl;

import org.wso2.carbon.auth.user.info.UserInfoResponseBuilder;
import org.wso2.carbon.auth.user.info.configuration.UserInfoConfigurationService;
import org.wso2.carbon.auth.user.info.exception.UserInfoException;
import org.wso2.carbon.auth.user.info.util.UserInfoUtil;

/**
 * Factory class for user info
 */
public class UserInfoFactory {

    /**
     * Retrieve UserInfoResponseBuilder
     *
     * @return UserInfoResponseBuilder instance
     * @throws UserInfoException if failed to retrieve UserInfoResponseBuilder instance
     */
    public static UserInfoResponseBuilder getUserInfoResponseBuilder() throws UserInfoException {

        UserInfoConfigurationService userInfoConfigurationService = UserInfoUtil.getUserInfoConfigurationService();
        String responseBuilderClassName = userInfoConfigurationService.getUserInfoConfiguration()
                .getResponseBuilderClassName();

        try {
            UserInfoResponseBuilder userInfoResponseBuilder = (UserInfoResponseBuilder) Class
                    .forName(responseBuilderClassName).newInstance();
            return userInfoResponseBuilder;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new UserInfoException("Error while initializing UserInfoResponseBuilder", e);
        }
    }
}
