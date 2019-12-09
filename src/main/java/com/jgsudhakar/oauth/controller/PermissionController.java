/**
 * 
 */
package com.jgsudhakar.oauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jgsudhakar.oauth.modal.PermissionDTO;
import com.jgsudhakar.oauth.service.PermissionService;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.controller.PermissionController.java
 * 2019-12-07
 */
@RestController
@RequestMapping("/permission/1.0/")
public class PermissionController {
	
	@Autowired
	PermissionService permissionService;
	
	@RequestMapping(value="/permissionList", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('READ')")
	public List<PermissionDTO> retriveRoleList(){
		return permissionService.retrivePermissions();
	}
	

	@PostMapping(value = "/savePermission", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PermissionDTO> saveRole(@RequestBody PermissionDTO permissionDTO) {
		return ResponseEntity.ok(permissionService.savePermission(permissionDTO));
	}

	@PostMapping(value = "/updatePermission", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PermissionDTO> updateRole(@RequestBody PermissionDTO permissionDTO) {
		return ResponseEntity.ok(permissionService.updatePermission(permissionDTO));
	}

	@DeleteMapping(value = "/deletePermission/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteRole(@PathVariable("id") Long roleId) {
		permissionService.deletePermission(roleId);
		return ResponseEntity.ok(HttpStatus.NO_CONTENT);
	}

}
