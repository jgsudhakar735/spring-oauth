/**
 * 
 */
package com.jgsudhakar.oauth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

import com.jgsudhakar.oauth.modal.ErrorRes;

import lombok.extern.log4j.Log4j2;

/**
 * @author sudhakar.t
 *
 */
@Component
@Log4j2
public class InvalidTokenException implements WebResponseExceptionTranslator<OAuth2Exception>{
	   /**
	    * This method will flush the exceptions from authorization server
	    */
	   @Override
	   public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
		   
		   log.error("{}" , ()-> e.getMessage());

	      ErrorRes errorRes = new ErrorRes(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, e.getMessage());

	      ResponseEntity<OAuth2Exception> entity = new ResponseEntity(errorRes, HttpStatus.BAD_REQUEST);

	      return entity;
	   }
}
