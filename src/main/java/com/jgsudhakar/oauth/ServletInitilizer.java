/**
 * 
 */
package com.jgsudhakar.oauth;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author sudhakar.t
 *
 */


/**
 * This class will be used to initialize when we are running spring boot application as a war. 
 * Application Server container will pick this and initialize the configuration.
 *
 */
public class ServletInitilizer extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringOauthApplication.class);
	}
}
