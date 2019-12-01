/**
 * 
 */
package com.jgsudhakar.oauth.modal;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.modal.PermissionDTO.java
 * 2019-11-29
 */
@Data
public class PermissionDTO implements Serializable{

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;

		private Long permissionId;

	    private String name;
	    
	    private String description;
}
