/**
 * 
 */
package com.jgsudhakar.oauth.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jgsudhakar.oauth.entity.UserEntity;
import com.jgsudhakar.oauth.modal.CustomUserDetails;
import com.jgsudhakar.oauth.repository.UserRepository;
import com.jgsudhakar.oauth.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sudhakar.t
 *
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		log.info("{} inside loadUserName::");
		Optional<UserEntity> usersOptional = userRepository.findByName(userId);

        usersOptional
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        
        UserDetails userDetails = new CustomUserDetails(usersOptional.get());
        
        new AccountStatusUserDetailsChecker().check(userDetails);
        
        return userDetails;
	}

}
