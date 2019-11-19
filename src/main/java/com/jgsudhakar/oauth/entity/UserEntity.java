/**
 * 
 */
package com.jgsudhakar.oauth.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author sudhakar.t
 *
 */
@Entity
@Table(name = "USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends CommonEntity implements Serializable{

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_KEY")
	private Long userKey;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_PASSWORD")
	private String password;
	
	@Column(name="USER_STATUS")
	private String userStatus;
	
	@Column(name = "PASSWORD_STATUS")
	private String passwordStatus;

	@Column(name = "FAILED_LOGIN_ATTEMPTS")
	private Integer failedLoginCount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_LOGIN")
	private Date last_login;
	
	private boolean enabled;
	
	private boolean accountNonExpired;
	
	private boolean credentialsNonExpired;
	
	private boolean accountNonLocked;	
	
	
}
