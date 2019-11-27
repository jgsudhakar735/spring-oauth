/**
 * 
 */
package com.jgsudhakar.oauth.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sudhakar.t
 *
 */
@Getter
@Setter
public class CommonEntity {

	@Column(name = "CREATED_BY",nullable = false)
	protected String createdBy;

	@Column(name = "UPDATED_BY" ,nullable = true)
	protected String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false)
	protected Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_BY",nullable = true)
	protected Date updatedDate;
}
