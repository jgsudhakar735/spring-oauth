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

import com.jgsudhakar.oauth.modal.RoleDTO;
import com.jgsudhakar.oauth.service.RoleService;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.controller.RoleController.java
 * 2019-12-07
 */
@RestController
@RequestMapping("/role/1.0")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="/roleList", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('READ')")
	public List<RoleDTO> retriveRoleList(){
		return roleService.retriveRoles();
	}
	
	@PostMapping(value = "/saveRole", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO) {
		return ResponseEntity.ok(roleService.saveRole(roleDTO));
	}

	@PostMapping(value = "/updateRole", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO) {
		return ResponseEntity.ok(roleService.updateRole(roleDTO));
	}

	@DeleteMapping(value = "/deleteRole/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteRole(@PathVariable("id") Long roleId) {
		roleService.deleteRole(roleId);
		return ResponseEntity.ok(HttpStatus.NO_CONTENT);
	}

}
