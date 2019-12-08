/**
 * 
 */
package com.jgsudhakar.oauth.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgsudhakar.oauth.entity.Role;
import com.jgsudhakar.oauth.exception.OAuthServiceException;
import com.jgsudhakar.oauth.exception.RecordNotExistException;
import com.jgsudhakar.oauth.modal.RoleDTO;
import com.jgsudhakar.oauth.repository.RoleRepository;
import com.jgsudhakar.oauth.service.RoleService;
import com.jgsudhakar.oauth.util.MapperUtlity;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.impl.RoleServiceImpl.java
 * 2019-12-07
 */
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	MapperUtlity mapperUtility;

	@Override
	public RoleDTO saveRole(RoleDTO roleDTO) throws OAuthServiceException {
		return mapperUtility.convertFromDataBaseEntity(
				roleRepository.save(
						mapperUtility.convertToDataBaseEntity(roleDTO)
						)
				);
	}

	@Override
	public List<RoleDTO> retriveRoles() throws OAuthServiceException {
		List<Role> findAll = roleRepository.findAll();
		return Optional.ofNullable(findAll).
				orElse(Collections.emptyList()).
								stream().map(roleEntity -> {
									return mapperUtility.convertFromDataBaseEntity(roleEntity);
								}).collect(Collectors.toList());
	}

	@Override
	public RoleDTO getRoleDetails(Long id) throws OAuthServiceException {
		Optional<Role> findById = roleRepository.findById(id);
		if(!findById.isPresent())
			throw new RecordNotExistException("404", "Role Does Not Exist!");

		return mapperUtility.convertFromDataBaseEntity(findById.get());
	}

	@Override
	public RoleDTO updateRole(RoleDTO roleDTO) throws OAuthServiceException {
		return mapperUtility.convertFromDataBaseEntity(
				roleRepository.save(
						mapperUtility.convertToDataBaseEntity(roleDTO)
						)
				);
	}

	@Override
	public void deleteRole(Long id) throws OAuthServiceException {
		roleRepository.deleteById(id);
	}

}
