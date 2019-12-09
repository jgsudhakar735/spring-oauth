/**
 * 
 */
package com.jgsudhakar.oauth.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jgsudhakar.oauth.exception.ExceptionResponse;
import com.jgsudhakar.oauth.exception.OAuthServiceException;
import com.jgsudhakar.oauth.exception.OAuthValidationException;
import com.jgsudhakar.oauth.exception.RecordNotExistException;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.controller.ExceptionController.java
 * $Version 1.0
 */

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value=OAuthServiceException.class)
	public ResponseEntity<ExceptionResponse> validationExceptionHandler(OAuthServiceException ex){
		ExceptionResponse errorRes = new ExceptionResponse();
		errorRes.setDetails(ex.getMessage());	
		errorRes.setMessage(ex.getMessage());
		errorRes.setTimestamp(new Date());
		return new ResponseEntity<ExceptionResponse>(errorRes,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=RecordNotExistException.class)
	public ResponseEntity<ExceptionResponse> validationExceptionHandler(RecordNotExistException ex){
		ExceptionResponse errorRes = new ExceptionResponse();
		errorRes.setDetails(ex.getMessage());	
		errorRes.setMessage(ex.getErrorCode());
		errorRes.setTimestamp(new Date());
		return new ResponseEntity<ExceptionResponse>(errorRes,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=OAuthValidationException.class)
	public ResponseEntity<ExceptionResponse> validationExceptionHandler(OAuthValidationException ex){
		ExceptionResponse errorRes = new ExceptionResponse();
		errorRes.setDetails(ex.getMessage());	
		errorRes.setMessage(ex.getErrorCode());
		errorRes.setTimestamp(new Date());
		return new ResponseEntity<ExceptionResponse>(errorRes,HttpStatus.BAD_REQUEST);
	}
	
}
