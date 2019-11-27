/**
 * 
 */
package com.jgsudhakar.oauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgsudhakar.oauth.modal.AuthorDTO;
import com.jgsudhakar.oauth.service.AuthorService;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.controller.AuthorController.java
 * 2019-11-25
 */
@RestController
@RequestMapping("/author/1.0/")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping(path = "/saveAuthor",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void saveAuthor(@RequestBody AuthorDTO authorDTO) {
		authorService.saveAuthor(authorDTO);
	}
	
	@GetMapping(path = "/retriveAuthors",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<AuthorDTO> retriveAuthors() {
		return authorService.retriveAuthors();
	}
	
	@GetMapping(path = "/getAuthorDetails/{authorId}",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public AuthorDTO getAuthorDetaila(@PathVariable("authorId") Long authorId) {
		return authorService.getAuthorDetails(authorId);
	}

	@DeleteMapping(path = "/deleteAuthor/{authorId}",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public void deleteAuthor(@PathVariable("authorId") Long authorId) {
		authorService.deleteAuthor(authorId);
	}

}
