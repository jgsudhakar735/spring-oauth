/**
 * 
 */
package com.jgsudhakar.oauth.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("in the LoadUserByUserName method");
		
		Optional<UserEntity> userDetails = userRepository.findByUserName(username);
		
		if(!userDetails.isPresent())
			throw new UsernameNotFoundException("USER_NO_EXIST");
		
		UserEntity entity  = userDetails.get();
		
		User user = new User(entity.getUserName(),entity.getPassword(),true,true,true,true,Collections.emptyList());
		
//		 List<SecurityGroup> securityGroups = securityGroupService.listUserGroups(user.getCompanyId(), user.getId());
		return new CustomUserDetails().builder().user(user).build();
	}

}
