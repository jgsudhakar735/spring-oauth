/**
 * 
 */
package com.jgsudhakar.oauth.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jgsudhakar.oauth.exception.OAuthServiceException;
import com.jgsudhakar.oauth.modal.UserDTO;

/**
 * @author sudhakar.t
 *
 */
public interface UserService extends UserDetailsService{

	public void saveUser(UserDTO userDTO) throws OAuthServiceException;
	
	public List<UserDTO> retriveUsers() throws OAuthServiceException;
	
	public UserDTO getUserDetails(Long id) throws OAuthServiceException;
	
	public void updateUser(UserDTO userDTO) throws OAuthServiceException;

	public void deleteUser(Long id) throws OAuthServiceException;
}
