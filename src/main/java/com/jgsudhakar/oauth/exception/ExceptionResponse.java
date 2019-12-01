/**
 * 
 */
package com.jgsudhakar.oauth.exception;

import java.util.Date;

/**
 * @author Sudhakar Tangellapalli
 * com.qikpay.exceptions.ExceptionResponse.java
 * 24-08-2019
 * $Version 1.0
 */
public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse() {
	
	}
	
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}


	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
