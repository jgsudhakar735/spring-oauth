/**
 * 
 */
package com.jgsudhakar.oauth.modal;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.modal.RoleDTO.java
 * 2019-11-28
 */
@Data
public class RoleDTO implements Serializable{

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	private int roleId;

	private String name;

	private String description;
}
