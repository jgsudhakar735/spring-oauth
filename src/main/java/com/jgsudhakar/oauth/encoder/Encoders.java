/**
 * 
 */
package com.jgsudhakar.oauth.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author sudhakar.t
 *
 */

/**
 * This is used to to do {@link Encoders} algorithm with number of rounds.
 */
public class Encoders {
	
	public PasswordEncoder oauthClientPasswordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
	
	public PasswordEncoder userPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
	}
}
