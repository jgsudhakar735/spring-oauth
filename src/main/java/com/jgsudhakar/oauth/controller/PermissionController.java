/**
 * 
 */
package com.jgsudhakar.oauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

}
