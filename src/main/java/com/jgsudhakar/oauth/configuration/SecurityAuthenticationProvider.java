/**
 * 
 */
package com.jgsudhakar.oauth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sudhakar.t
 *
 */
@Configuration
public class SecurityAuthenticationProvider extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
