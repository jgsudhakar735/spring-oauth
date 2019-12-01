package com.jgsudhakar.oauth.exception;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.exceptions.QikPayOptimisticLockException.java
 * 27-08-2019
 * $Version 1.0
 */
public class OAuthOptimisticLockException extends OAuthServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OAuthOptimisticLockException(String errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}

}
