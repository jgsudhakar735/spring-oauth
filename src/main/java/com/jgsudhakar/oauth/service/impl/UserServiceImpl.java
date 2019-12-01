/**
 * 
 */
package com.jgsudhakar.oauth.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jgsudhakar.oauth.entity.UserEntity;
import com.jgsudhakar.oauth.exception.OAuthServiceException;
import com.jgsudhakar.oauth.exception.RecordNotExistException;
import com.jgsudhakar.oauth.modal.CustomUserDetails;
import com.jgsudhakar.oauth.modal.UserDTO;
import com.jgsudhakar.oauth.repository.UserRepository;
import com.jgsudhakar.oauth.service.UserService;
import com.jgsudhakar.oauth.util.MapperUtlity;

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
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	private MapperUtlity mapperUtility;

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

	@Override
	public void saveUser(UserDTO userDTO) throws OAuthServiceException {
		UserEntity entity = mapperUtility.convertToDataBaseEntity(userDTO);
		userRepository.save(entity);
	}

	@Override
	public List<UserDTO> retriveUsers() throws OAuthServiceException {
		List<UserEntity> findAll = userRepository.findAll();
		return Optional.ofNullable(findAll).
				orElse(Collections.emptyList()).
								stream().map(userEntity -> {
									return mapperUtility.convertFromDataBaseEntity(userEntity);
								}).collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserDetails(Long id) throws OAuthServiceException {
		Optional<UserEntity> findById = userRepository.findById(id);
		if(!findById.isPresent())
			throw new RecordNotExistException("404", "User Does Not Exist!");

		return mapperUtility.convertFromDataBaseEntity(findById.get());
	}

	@Override
	public void updateUser(UserDTO userDTO) throws OAuthServiceException {
		
		
	}

	@Override
	public void deleteUser(Long id) throws OAuthServiceException {
		userRepository.deleteById(id);
	}

}
