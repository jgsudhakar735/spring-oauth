/**
 * 
 */
package com.jgsudhakar.oauth.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.jgsudhakar.oauth.modal.ErrorRes;

import lombok.extern.log4j.Log4j2;

/**
 * @author sudhakar.t
 *
 */
@Component
@Log4j2
public class CustomExceptionHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.error("{}",() -> request.getRequestURL());
		log.error("{}",() -> accessDeniedException.getMessage());
		if (response.getStatus() == 200) {
	         response.setStatus(403);
	      }
	      response.setContentType("application/json");

	      ErrorRes errorRes = new ErrorRes(response.getStatus(), HttpStatus.FORBIDDEN, accessDeniedException.getMessage());

	      response.getOutputStream().write(new Gson().toJson(errorRes).getBytes());
	      response.getOutputStream().flush();
	      response.getOutputStream().close();
			
	}

}
