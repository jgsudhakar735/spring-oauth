/**
 * 
 */
package com.jgsudhakar.oauth.configuration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author sudhakar.t
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter{

	public static final String resourceId = "RESOURCE_ID";
	
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(resourceId).stateless(false);
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
         http.requestMatcher(new OAuthRequestedMatcher())
                .authorizeRequests()
                 .antMatchers(HttpMethod.OPTIONS).permitAll()
                    .anyRequest().authenticated();
    }
    private static class OAuthRequestedMatcher implements RequestMatcher {
        public boolean matches(HttpServletRequest request) {
            String auth = request.getHeader("Authorization");
            // Determine if the client request contained an OAuth Authorization
            boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
            boolean haveAccessToken = request.getParameter("access_token")!=null;
   return haveOauth2Token || haveAccessToken;
        }
    }

}
