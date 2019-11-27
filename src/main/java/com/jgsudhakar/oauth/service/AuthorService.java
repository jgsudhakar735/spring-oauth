/**
 * 
 */
package com.jgsudhakar.oauth.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.jgsudhakar.oauth.modal.AuthorDTO;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.AuthorService.java
 * 2019-11-25
 */
public interface AuthorService {
	
	/**
	 * This method can be access by any client/user who has ADMIN or USER Role mapped. Other Role Type Users
	 * can not access.
	 * @param authorDTO
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public void saveAuthor(AuthorDTO authorDTO);
	
	/**
	 * This method can be accessed by Only ADMIN role user. Others users cannot access and SYstem will throw Access Denied exception.
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<AuthorDTO> retriveAuthors();
	
	/**
	 * This method can be accessed by Only READ Authority user. Others users cannot access and System will throw Access Denied exception.
	 * @return
	 */
	 @PreAuthorize("hasAuthority('READ')")
	public AuthorDTO getAuthorDetails(Long authorId);
	 
	 
	 /**
	 * This method can be accessed by Only READ Authority users. Others users cannot access and SYstem will throw Access Denied exception.
	 * @return
	 */
	@PreAuthorize("hasAuthority('READ')")
	public List<AuthorDTO> getAuthorsList(String authorName);
	
	/**
	 * This method can be accessed by Only DELETE Authority user. Others users cannot access and SYstem will throw Access Denied exception.
	 * @return
	 */
	@PreAuthorize("hasAuthority('DELETE')")
	public void deleteAuthor(Long authorId);
	
	/**
	 * This method can be accessed by Only UPDATE Authority user. Others users cannot access and SYstem will throw Access Denied exception.
	 * @return
	 */
	@PreAuthorize("hasAuthority('UPDATE')")
	public void updateAuthor(AuthorDTO authorDTO);

}
