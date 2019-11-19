/**
 * 
 */
package com.jgsudhakar.oauth.configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sudhakar.t
 *
 */
//@Configuration
//@EnableGlobalAuthentication
public class SpringSecurity_BK extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
        .withUser("user").password("{noop}password").roles("USER")
        .and()
        .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        //HTTP Basic authentication
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/1.0/**").hasRole("USER")
        .and()
        .csrf().disable()
        .formLogin().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.GET);
	}
}
