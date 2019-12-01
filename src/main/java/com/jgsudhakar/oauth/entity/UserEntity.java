/**
 * 
 */
package com.jgsudhakar.oauth.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "failed_login_attempts")
    private Integer failedLoginAttemptCount;

    @Column(name = "last_login")
    private Date lastLoginDate;

    @Column(name = "user_name")
    private String name;
    
    @Column(name = "user_password")
    private String password;
    
    @Column(name = "password_status")
    private String passwordStatus;
    
    @Column(name = "accountNonExpired")
    private String accountNonExpired;
    
    @Column(name = "accountNonLocked")
    private String accountNonLocked;
    
    @Column(name = "user_status")
    private int active;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns =
    @JoinColumn(name = "user_id"), inverseJoinColumns =
    @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public UserEntity (UserEntity entity) {
    	this.name = entity.getName();
    	this.active = entity.getActive();
    	this.password = entity.getPassword();
    	this.passwordStatus = entity.getPasswordStatus();
    	this.id = entity.getId();
    	this.lastLoginDate = entity.getLastLoginDate();
    	this.failedLoginAttemptCount = entity.getFailedLoginAttemptCount();
        this.roles = entity.roles;
        this.accountNonExpired = entity.accountNonExpired;
        this.accountNonLocked = entity.accountNonLocked;
    }
}
