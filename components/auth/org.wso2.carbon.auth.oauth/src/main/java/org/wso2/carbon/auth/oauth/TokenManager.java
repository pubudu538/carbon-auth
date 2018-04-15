/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.auth.oauth;

import org.wso2.carbon.auth.oauth.dto.AccessTokenDTO;

/**
 * Manage token related functions
 */
public interface TokenManager {
    /**
     * Persist token information
     *
     * @param accessToken                Access token value
     * @param refreshToken               Refresh token value
     * @param clientID                   ClientID value
     * @param authUser                   Authenticated user
     * @param userDomain                 User domain
     * @param timeCreated                Created time
     * @param refreshTokenCreatedTime    Refresh token created time
     * @param validityPeriod             Validity Period
     * @param refreshTokenValidityPeriod Refresh token validity period
     * @param tokenScopeHash             Token scope hash
     * @param tokenState                 Token state
     * @param userType                   User type
     * @param grantType                  Grant type
     */
    void storeToken(String accessToken, String refreshToken, String clientID, String authUser, String userDomain,
                    long timeCreated, long refreshTokenCreatedTime, int validityPeriod, int refreshTokenValidityPeriod,
                    String tokenScopeHash, String tokenState, String userType, String grantType);

    /**
     * Retrieve token information
     *
     * @param accessToken Access token value
     * @return AccessTokenDTO
     */
    AccessTokenDTO getTokenInfo(String accessToken);
}
