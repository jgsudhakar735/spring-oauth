/**
 * 
 */
package com.jgsudhakar.oauth.util;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jgsudhakar.oauth.entity.ClientDetailsEntity;
import com.jgsudhakar.oauth.entity.Permission;
import com.jgsudhakar.oauth.entity.Role;
import com.jgsudhakar.oauth.entity.UserEntity;
import com.jgsudhakar.oauth.exception.OAuthValidationException;
import com.jgsudhakar.oauth.modal.ClientDetailsDTO;
import com.jgsudhakar.oauth.modal.PermissionDTO;
import com.jgsudhakar.oauth.modal.RoleDTO;
import com.jgsudhakar.oauth.modal.UserDTO;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.util.MapperUtlity.java
 * 2019-11-28
 */
@Component
public class MapperUtlity {

	public UserEntity convertToDataBaseEntity(UserDTO userDTO) {
		if(null == userDTO)
			throw new OAuthValidationException("400", ErrorMessages.OBJECT_CANNOT_NULL);
		
		UserEntity entity = new UserEntity();
		
		return entity;
	}
	
	public UserDTO convertFromDataBaseEntity(UserEntity userEntity) {
		if(null == userEntity)
			return null;
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setName(userEntity.getName());
		userDTO.setPasswordStatus(userEntity.getPasswordStatus());
		userDTO.setAccountNonExpired(userEntity.getAccountNonExpired());
		userDTO.setAccountNonLocked(userEntity.getAccountNonLocked());
		userDTO.setFailedLoginAttemptCount(userEntity.getFailedLoginAttemptCount());
		userDTO.setActive(userEntity.getActive());
		userDTO.setLastLoginDate(userEntity.getLastLoginDate());
		userDTO.setRoles(
				Optional.ofNullable(userEntity.getRoles()).
						orElse(Collections.emptySet()).
						stream().map(role->{
							return convertFromDataBaseEntity(role); 
						}).collect(Collectors.toSet())
						);
		
		
		return userDTO;
	}
	
	public Role convertToDataBaseEntity(RoleDTO roleDTO) {
		if(null == roleDTO)
			throw new OAuthValidationException("400", ErrorMessages.OBJECT_CANNOT_NULL);
		
		Role role = new Role();
		role.setName(roleDTO.getName());
		role.setDescription(roleDTO.getDescription());
		if(roleDTO.getRoleId() != null && roleDTO.getRoleId() > 0)
			role.setRoleId(roleDTO.getRoleId());
		
		return role;
	}
	
	public RoleDTO convertFromDataBaseEntity(Role role) {
		if(null == role)
			return null;
			
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setName(role.getName());
		roleDTO.setRoleId(role.getRoleId());
		roleDTO.setDescription(role.getDescription());
		return roleDTO;
	}
	
	public Permission convertToDataBaseEntity(PermissionDTO permissionDTO) {
		if(null == permissionDTO)
			throw new OAuthValidationException("400", ErrorMessages.OBJECT_CANNOT_NULL);
		
		Permission permission = new Permission();
		permission.setName(permissionDTO.getName());
		permission.setDescription(permissionDTO.getDescription());
		return permission;
	}
	
	public PermissionDTO convertFromDataBaseEntity(Permission permission) {
		
		if(null == permission)
			return null;
		
		PermissionDTO permissionDto = new PermissionDTO();
		permissionDto.setPermissionId(permission.getPermissionId());
		permissionDto.setName(permission.getName());
		permissionDto.setDescription(permission.getDescription());
		return permissionDto;
	}
	
	public ClientDetailsEntity convertToDataBaseEntity(ClientDetailsDTO clientDetailsDTO) {
		if(null == clientDetailsDTO)
			throw new OAuthValidationException("400", ErrorMessages.OBJECT_CANNOT_NULL);
		ClientDetailsEntity detailsEntity = new ClientDetailsEntity();
		detailsEntity.setAccess_token_validity(clientDetailsDTO.getAccess_token_validity());
		detailsEntity.setAdditional_information(clientDetailsDTO.getAdditional_information());
		detailsEntity.setAuthorities(clientDetailsDTO.getScope());
		detailsEntity.setAuthorized_grant_types(clientDetailsDTO.getAuthorized_grant_types());
		detailsEntity.setClient_secret(clientDetailsDTO.getClient_secret());
		detailsEntity.setRefresh_token_validity(clientDetailsDTO.getRefresh_token_validity());
		detailsEntity.setWeb_server_redirect_uri(clientDetailsDTO.getWeb_server_redirect_uri());
		detailsEntity.setClient_id(clientDetailsDTO.getClient_id());
		
		return detailsEntity;
	}
	
	public ClientDetailsDTO convertFromDataBaseEntity(ClientDetailsEntity clientDetailsEntity) {
		if(null == clientDetailsEntity)
			return null;
		
		ClientDetailsDTO clientDetailsDTO = new ClientDetailsDTO();
		clientDetailsDTO.setAccess_token_validity(clientDetailsEntity.getAccess_token_validity());
		clientDetailsDTO.setAdditional_information(clientDetailsEntity.getAdditional_information());
		clientDetailsDTO.setAuthorities(clientDetailsEntity.getScope());
		clientDetailsDTO.setAuthorized_grant_types(clientDetailsEntity.getAuthorized_grant_types());
		clientDetailsDTO.setClient_secret(clientDetailsEntity.getClient_secret());
		clientDetailsDTO.setRefresh_token_validity(clientDetailsEntity.getRefresh_token_validity());
		clientDetailsDTO.setWeb_server_redirect_uri(clientDetailsEntity.getWeb_server_redirect_uri());
		clientDetailsDTO.setClient_id(clientDetailsEntity.getClient_id());
		clientDetailsDTO.setId(clientDetailsEntity.getId());
		
		return clientDetailsDTO;
	}
}
