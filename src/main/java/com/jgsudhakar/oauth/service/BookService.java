/**
 * 
 */
package com.jgsudhakar.oauth.service;

import java.util.List;

import com.jgsudhakar.oauth.modal.BookDTO;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.BookService.java
 * 2019-11-25
 */
public interface BookService {
	
	public void saveBook(BookDTO bookDTO);
	
	public List<BookDTO> retriveBooks();
	
	public BookDTO getBookDetails(Long bookId);

	public List<BookDTO> getBooksList(String bookName);
	
	public void deleteBook(Long bookId);
	
	public void updateAuthor(BookDTO bookDTO);

}
