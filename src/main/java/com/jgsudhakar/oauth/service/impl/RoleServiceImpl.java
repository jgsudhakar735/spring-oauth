/**
 * 
 */
package com.jgsudhakar.oauth.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jgsudhakar.oauth.entity.Role;
import com.jgsudhakar.oauth.exception.OAuthServiceException;
import com.jgsudhakar.oauth.exception.RecordNotExistException;
import com.jgsudhakar.oauth.modal.RoleDTO;
import com.jgsudhakar.oauth.repository.RoleRepository;
import com.jgsudhakar.oauth.service.RoleService;
import com.jgsudhakar.oauth.util.MapperUtlity;

import lombok.extern.log4j.Log4j2;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.impl.RoleServiceImpl.java
 * 2019-12-07
 */
@Service
@Log4j2
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
		Optional<Role> findById = roleRepository.findById(roleDTO.getRoleId());
		if(findById.isPresent()) {
			Role role = findById.get();
			role.setDescription(roleDTO.getDescription());
			return mapperUtility.convertFromDataBaseEntity(
					roleRepository.save(role)
					);
		}
		throw new RecordNotExistException("404", "Role Does Not Exist!"); 
	}

	@Override
	public void deleteRole(Long id) throws OAuthServiceException {
		try {
			roleRepository.deleteById(id);
		} catch (Exception e) {
			log.error("{}",e.getMessage());
			if(e instanceof DataIntegrityViolationException)
				throw new OAuthServiceException("400", "Data Mapped to Child Tables!, Please delete those first");
			
			throw e;
		}
	}

}
