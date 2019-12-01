/**
 * 
 */
package com.jgsudhakar.oauth.exception;

/**
 * @author Sudhakar Tangellapalli
 * com.qikpay.exceptions.RecordNotExistException.java
 * 24-08-2019
 * $Version 1.0
 */
public class RecordNotExistException extends OAuthServiceException {

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	public RecordNotExistException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public RecordNotExistException(String errorCode,String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public RecordNotExistException(String errorCode,String errorMessage,Throwable throwable) {
		super(errorMessage,errorCode,throwable);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getErrorCode() {
		return super.getErrorCode();
	}
	
	@Override
	public String getErrorMessage() {
		return super.getErrorMessage();
	}

}
