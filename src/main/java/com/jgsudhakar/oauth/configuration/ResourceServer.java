/**
 * 
 */
package com.jgsudhakar.oauth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.jgsudhakar.oauth.exception.AccessDeniedCustomException;
import com.jgsudhakar.oauth.exception.AuthenticationRequired;

/**
 * @author sudhakar.t
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServer implements ResourceServerConfigurer{
	
	@Autowired
	private AccessDeniedCustomException accessDeniedException;
	
	@Autowired
	TokenStore tokenStore;
	

	@Autowired
	public JwtAccessTokenConverter accessTokenConverter;
	
	private static final String RESOURCE_ID = "RESOURCE_ID";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID).tokenStore(tokenStore).authenticationEntryPoint(authenticationEntryPoint());
	}
	
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationRequired();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		/*
		 * http.requestMatchers()
		 * .antMatchers(SECURED_PATTERN).and().authorizeRequests().antMatchers(
		 * SECURED_PATTERN).hasAnyRole("ADMIN","OPERATOR"). and()
		 * .antMatcher(SECURED_PATTERN_POST).authorizeRequests().antMatchers(
		 * SECURED_PATTERN_POST).hasAnyRole("ADMIN") .anyRequest().authenticated();
		 */
	        http
	            .authorizeRequests()
	            .antMatchers("/users/**").authenticated()
	            .antMatchers("/1.0/**").permitAll().
	            and().exceptionHandling().accessDeniedHandler(accessDeniedException).authenticationEntryPoint(authenticationEntryPoint());
	}
	
}