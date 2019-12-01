package com.jgsudhakar.oauth.exception;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.exceptions.QikPayConstraintViolationException.java
 * 27-08-2019
 * $Version 1.0
 */
public class OAuthConstraintViolationException extends OAuthServiceException{

	private static final long serialVersionUID = 1L;

	public OAuthConstraintViolationException(String errorMessage) {
		super(errorMessage);
	}

}
