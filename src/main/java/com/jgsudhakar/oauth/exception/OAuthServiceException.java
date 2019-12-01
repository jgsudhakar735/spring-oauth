/**
 * 
 */
package com.jgsudhakar.oauth.exception;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.exceptions.QikPayServiceException.java
 * 23-08-2019
 * $Version 1.0
 */
public class OAuthServiceException extends RuntimeException{

	/**
	 * Default Serial ID
	 */
	private static final long serialVersionUID = 1L;

	protected String errorMessage;

	protected String errorCode;

	public OAuthServiceException(String errorMessage){
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public OAuthServiceException(String errorCode,String errorMessage){
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	public OAuthServiceException(Throwable throwable){
		super(throwable);
		this.errorMessage = throwable.getMessage();
	}
	
	public OAuthServiceException(String errorMessage,Throwable throwable){
		super(errorMessage,throwable);
		this.errorMessage = errorMessage;
	}

	public OAuthServiceException(String errorMessage,String errorCode, Throwable throwable){
		super(errorMessage,throwable);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	
	
	
}
