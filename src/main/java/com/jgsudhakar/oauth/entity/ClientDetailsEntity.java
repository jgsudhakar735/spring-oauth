/**
 * 
 */
package com.jgsudhakar.oauth.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.entity.ClientDetailsEntity.java
 * 2019-11-29
 */
@Entity
@Table(name = "oauth_client_details")
@Data
@EqualsAndHashCode(callSuper = false)
public class ClientDetailsEntity implements Serializable {

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Long id;
	
	@Column(name = "client_id")
	private String client_id;
	
	@Column(name = "resource_ids")
	private String resource_ids;
	
	@Column(name = "client_secret")
	private String client_secret;

	@Column(name = "scope")
	private String 	scope;
	
	@Column(name = "authorized_grant_types")
	private String 	authorized_grant_types;
	
	@Column(name = "web_server_redirect_uri")
	private String 	web_server_redirect_uri;
	
	@Column(name = "authorities")
	private String 	authorities;
	
	@Column(name = "access_token_validity")
	private Integer	access_token_validity;

	@Column(name = "refresh_token_validity")
	private Integer refresh_token_validity;
	
	@Column(name = "additional_information")
	private String additional_information;
	
	@Column(name = "autoapprove")
	private String autoapprove;
}
