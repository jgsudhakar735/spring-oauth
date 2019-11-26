/**
 * 
 */
package com.jgsudhakar.oauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgsudhakar.oauth.modal.AuthorDTO;
import com.jgsudhakar.oauth.service.AuthorService;
import com.jgsudhakar.oauth.util.JwtTokenUtil;

import lombok.extern.log4j.Log4j2;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.controller.AuthorController.java
 * 2019-11-25
 */
@RestController
@RequestMapping("/author/1.0/")
@Log4j2
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping(path = "/saveAuthor",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void saveAuthor(@RequestBody AuthorDTO authorDTO) {
		authorService.saveAuthor(authorDTO);
	}
	
	@PreAuthorize("hasAuthority('READ')")
	@GetMapping(path = "/retriveAuthors",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<AuthorDTO> retriveAuthors() {
		log.info("{}", () -> jwtTokenUtil.getUserName());
		return authorService.retriveAuthors();
	}

}
