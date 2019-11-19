/**
 * 
 */
package com.jgsudhakar.oauth.modal;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sudhakar.t
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomUserDetails implements UserDetails{

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
    private List<String> groups;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    @Override
    public String getUsername() {
        return user.getUsername();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
    
}
