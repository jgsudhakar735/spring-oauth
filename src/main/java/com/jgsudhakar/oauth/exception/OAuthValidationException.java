package com.jgsudhakar.oauth.exception;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.exceptions.QikPayValidationException.java
 * 27-08-2019
 * $Version 1.0
 */
public class OAuthValidationException extends OAuthServiceException{

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	public OAuthValidationException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public OAuthValidationException(String errorCode,String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public OAuthValidationException(String errorCode,String errorMessage,Throwable throwable) {
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
