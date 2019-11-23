/**
 * 
 */
package com.jgsudhakar.oauth.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.jgsudhakar.oauth.modal.ErrorRes;

/**
 * @author sudhakar.t
 *
 */
@Component
public class AuthenticationRequired implements AuthenticationEntryPoint{

	   /**
	    * This method flush the error response from resource server
	    */
	   @Override
	   public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

	      if (response.getStatus() == 200) {
	         response.setStatus(401);
	      }
	      response.setContentType("application/json");

	      ErrorRes errorRes = new ErrorRes(response.getStatus(), HttpStatus.UNAUTHORIZED, getExceptionMessage(exception));

	      response.getOutputStream().write(new Gson().toJson(errorRes).getBytes());
	      response.getOutputStream().flush();
	      response.getOutputStream().close();

	   }

	   /**
	    * @param exception
	    * @return
	    */
	   public String getExceptionMessage(AuthenticationException exception) {
	      String errorDescr = "Authentication required";
	      if (exception.getCause() != null && exception.getCause().getCause() != null && exception.getCause().getCause().getMessage() != null) {
	         errorDescr = exception.getCause().getCause().getMessage();
	      } else if (exception.getCause() != null && exception.getCause().getMessage() != null) {
	         errorDescr = exception.getCause().getMessage();
	      } else if (exception != null) {
	         errorDescr = exception.getMessage();
	      }
	      return errorDescr;
	   }

}
