/**
 * 
 */
package com.jgsudhakar.oauth.modal;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import lombok.Data;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.modal.UserDTO.java
 * 2019-11-28
 */
@Data
public class UserDTO implements Serializable{

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Integer failedLoginAttemptCount;

    private Date lastLoginDate;

    private String name;
    
    private String password;
    
    private String passwordStatus;
    
    private String accountNonExpired;
    
    private String accountNonLocked;
    
    private int active;
    
    private Set<RoleDTO> roles;

}
