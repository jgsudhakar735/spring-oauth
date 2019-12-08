/**
 * 
 */
package com.jgsudhakar.oauth.service;

import java.util.List;

import com.jgsudhakar.oauth.exception.OAuthServiceException;
import com.jgsudhakar.oauth.modal.RoleDTO;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.RoleService.java
 * 2019-12-07
 */
public interface RoleService {

	public RoleDTO saveRole(RoleDTO roleDTO) throws OAuthServiceException;
	
	public List<RoleDTO> retriveRoles() throws OAuthServiceException;
	
	public RoleDTO getRoleDetails(Long id) throws OAuthServiceException;
	
	public RoleDTO updateRole(RoleDTO userDTO) throws OAuthServiceException;

	public void deleteRole(Long id) throws OAuthServiceException;
}
