/**
 * 
 */
package com.jgsudhakar.oauth.service;

import java.util.List;

import com.jgsudhakar.oauth.modal.AuthorDTO;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.AuthorService.java
 * 2019-11-25
 */
public interface AuthorService {
	
	public void saveAuthor(AuthorDTO authorDTO);
	
	public List<AuthorDTO> retriveAuthors();
	
	public AuthorDTO getAuthorDetails(Long authorId);

	public List<AuthorDTO> getAuthorsList(String authorName);
	
	public void deleteAuthor(Long authorId);
	
	public void updateAuthor(AuthorDTO authorDTO);

}
