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

import com.jgsudhakar.oauth.entity.Permission;
import com.jgsudhakar.oauth.exception.OAuthServiceException;
import com.jgsudhakar.oauth.exception.RecordNotExistException;
import com.jgsudhakar.oauth.modal.PermissionDTO;
import com.jgsudhakar.oauth.repository.PermissionRepository;
import com.jgsudhakar.oauth.service.PermissionService;
import com.jgsudhakar.oauth.util.MapperUtlity;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.impl.PermissionServiceImpl.java
 * 2019-12-07
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Autowired
	PermissionRepository permissionRepository;
	
	@Autowired
	MapperUtlity mapperUtility;

	@Override
	public PermissionDTO savePermission(PermissionDTO permissionDTO) throws OAuthServiceException {
		return mapperUtility.convertFromDataBaseEntity(
				permissionRepository.save(
						mapperUtility.convertToDataBaseEntity(permissionDTO)
						)
				);
	}

	@Override
	public List<PermissionDTO> retrivePermissions() throws OAuthServiceException {
		List<Permission> findAll = permissionRepository.findAll();
		return Optional.ofNullable(findAll).
				orElse(Collections.emptyList()).
								stream().map(permissionEntity -> {
									return mapperUtility.convertFromDataBaseEntity(permissionEntity);
								}).collect(Collectors.toList());
	}

	@Override
	public PermissionDTO getPermissionDetails(Long id) throws OAuthServiceException {
		Optional<Permission> findById = permissionRepository.findById(id);
		if(!findById.isPresent())
			throw new RecordNotExistException("Permission Does Not Exist!");

		return mapperUtility.convertFromDataBaseEntity(findById.get());
	}

	@Override
	public PermissionDTO updatePermission(PermissionDTO permissionDTO) throws OAuthServiceException {
		Optional<Permission> findById = permissionRepository.findById(permissionDTO.getPermissionId());
		if(!findById.isPresent())
			throw new RecordNotExistException("Permission Does Not Exist!");
		
		Permission permission = findById.get();
		permission.setDescription(permissionDTO.getDescription());
		permissionRepository.save(permission);
		
		return permissionDTO;
	}

	@Override
	public void deletePermission(Long id) throws OAuthServiceException {
		try {
			permissionRepository.deleteById(id);
		} catch (Exception e) {
			if(e instanceof DataIntegrityViolationException)
				throw new OAuthServiceException("400", "Data Mapped to Child Tables!, Please delete those first");
			
			throw e;
		}
	}

}
