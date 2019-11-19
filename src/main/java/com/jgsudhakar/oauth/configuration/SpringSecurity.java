/**
 * 
 */
package com.jgsudhakar.oauth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.jgsudhakar.oauth.service.UserService;

/**
 * @author sudhakar.t
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1)
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService userService;
	
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userService)
	            .passwordEncoder(encoder());
	}
	
	/**
	 *Ignoring all the Options Request.
	 *If we want any specific Methods needs to exclude . Configure here.
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers( HttpMethod.OPTIONS, "/**" );
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .csrf().disable()
         .anonymous().disable()
         .authorizeRequests()
         .antMatchers("/oauth/token").permitAll() // oauth Token Request
         .antMatchers("/api-docs/**").permitAll(); // Swagger request
	}
	
	@Bean
    public PasswordEncoder encoder(){
        return  NoOpPasswordEncoder.getInstance();
    }
	
	@Bean
	public TokenStore tokenStore() {
	    return new InMemoryTokenStore();
	}
	
	@Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
