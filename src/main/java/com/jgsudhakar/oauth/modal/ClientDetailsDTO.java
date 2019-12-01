/**
 * 
 */
package com.jgsudhakar.oauth.modal;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.modal.ClientDetailsDTO.java
 * 2019-11-29
 */

@Data
public class ClientDetailsDTO implements Serializable{

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String client_id;
	
	private String resource_ids;
	
	private String client_secret;

	private String 	scope;
	
	private String 	authorized_grant_types;
	
	private String 	web_server_redirect_uri;
	
	private String 	authorities;
	
	private Integer	access_token_validity;

	private Integer refresh_token_validity;
	
	private String additional_information;
	
	private String autoapprove;
}
