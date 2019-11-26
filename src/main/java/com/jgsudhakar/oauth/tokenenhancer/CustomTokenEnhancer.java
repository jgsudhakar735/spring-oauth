/**
 * 
 */
package com.jgsudhakar.oauth.tokenenhancer;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

/**
 * @author sudhakar.t
 * <pre>
 *This class will be used to enhance Jwt Token. If We want to add any custom data to JWT Token we implement <strong>TokenEnhancer</strong>
 *</pre>
 */
@Component
public class CustomTokenEnhancer extends JwtAccessTokenConverter{

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new LinkedHashMap<String, Object>(
				accessToken.getAdditionalInformation());
		if (authentication.getUserAuthentication() != null) {
			info.put("userInfo", "Sudhakar");
		}

		DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(
				accessToken);
		info.put("accessTokenExpiryInSec", customAccessToken.getExpiresIn());

		customAccessToken.setAdditionalInformation(info);
		OAuth2AccessToken oauthValidation = super.enhance(customAccessToken,
				authentication);
		return oauthValidation;
	}

}
