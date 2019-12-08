/**
 * 
 */
package com.jgsudhakar.oauth.service;

import java.util.List;

import com.jgsudhakar.oauth.exception.OAuthServiceException;
import com.jgsudhakar.oauth.modal.PermissionDTO;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.PermissionService.java
 * 2019-12-07
 */
public interface PermissionService {

	public void savePermission(PermissionDTO permissionDTO) throws OAuthServiceException;
	
	public List<PermissionDTO> retrivePermissions() throws OAuthServiceException;
	
	public PermissionDTO getPermissionDetails(Long id) throws OAuthServiceException;
	
	public void updatePermission(PermissionDTO permissionDTO) throws OAuthServiceException;

	public void deletePermission(Long id) throws OAuthServiceException;
}
