/**
 * 
 */
package com.jgsudhakar.oauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgsudhakar.oauth.modal.BookDTO;
import com.jgsudhakar.oauth.repository.BookRepository;
import com.jgsudhakar.oauth.service.BookService;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.impl.BookServiceImpl.java
 * 2019-11-25
 */
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public void saveBook(BookDTO bookDTO) {
		

	}

	@Override
	public List<BookDTO> retriveBooks() {
		
		return null;
	}

	@Override
	public BookDTO getBookDetails(Long bookId) {
		
		return null;
	}

	@Override
	public List<BookDTO> getBooksList(String bookName) {
		
		return null;
	}

	@Override
	public void deleteBook(Long bookId) {
		

	}

	@Override
	public void updateAuthor(BookDTO bookDTO) {
		

	}

}
