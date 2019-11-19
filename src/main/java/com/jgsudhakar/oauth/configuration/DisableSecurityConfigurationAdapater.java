/**
 * 
 */
package com.jgsudhakar.oauth.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sudhakar.t
 *
 */
//@Configuration
//@Order(1)
public class DisableSecurityConfigurationAdapater extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests().anyRequest().permitAll();
    }
}
