/**
 * 
 */
package com.jgsudhakar.oauth.util;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.util.JwtTokenUtil.java
 * 2019-11-25
 */
@Component
@Log4j2
public class JwtTokenUtil implements Serializable{
	
	@Autowired
	TokenStore tokenStore;
	
	@Autowired
	HttpServletRequest httpServletRequest;

	/**
	 * Default Serial id
	 */
	private static final long serialVersionUID = 1L;

	public String getUserName() {
		return getAccessToken().getAdditionalInformation().get(OAuthConstants.USER_NAME).toString();
	}
	
	public Date getExpirationTime() {
		return getAccessToken().getExpiration();
	}
	
	public int tokenExpiresIn() {
		return getAccessToken().getExpiresIn();
	}
	
	public Set<String> getScopes() {
		return getAccessToken().getScope();
	}
	
	public OAuth2RefreshToken getRefreshToken() {
		return getAccessToken().getRefreshToken();
	}
	
	public boolean isTokenExpired() {
		return getAccessToken().isExpired();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getAdditionalInfo(String additionalInfoName, T returnType) {
		return (T)getAccessToken().getAdditionalInformation().get(additionalInfoName);
	}
	
	public OAuth2AccessToken getAccessToken() {
		String tokenValue = httpServletRequest.getHeader(OAuthConstants.AUTH_HEADER);
		OAuth2AccessToken readAccessToken = tokenStore.readAccessToken(tokenValue.replaceAll("Bearer ", ""));
		readAccessToken.getAdditionalInformation().entrySet().stream().forEach(x-> {
			log.info("{}",() -> x.getKey() + "::" + x.getValue());
		});
		return tokenStore.readAccessToken(tokenValue.replaceAll("Bearer ", ""));
	}
}
