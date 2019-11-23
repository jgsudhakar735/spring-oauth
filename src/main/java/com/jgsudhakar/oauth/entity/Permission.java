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

/**
 * @author sudhakar.t
 *
 */
@Entity
@Data
@Table(name = "permission")
public class Permission implements Serializable{

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int roleId;

    @Column(name = "name")
    private String name;
}
