/**
 * 
 */
package com.jgsudhakar.oauth.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgsudhakar.oauth.entity.Author;
import com.jgsudhakar.oauth.entity.Book;
import com.jgsudhakar.oauth.modal.AuthorDTO;
import com.jgsudhakar.oauth.modal.BookDTO;
import com.jgsudhakar.oauth.repository.BookRepository;
import com.jgsudhakar.oauth.service.AuthorService;
import com.jgsudhakar.oauth.service.BookService;
import com.jgsudhakar.oauth.util.JwtTokenUtil;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.impl.BookServiceImpl.java
 * 2019-11-25
 */
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public void saveBook(BookDTO bookDTO) {
		AuthorDTO authorDetails = authorService.getAuthorDetails(bookDTO.getAuthorId());
		if(null != authorDetails) {
			Author author = new Author();
			BeanUtils.copyProperties(author, authorDetails);
			Book book = new Book();
			book.setAuthor(author);
			book.setBookName(bookDTO.getBookName());
			book.setBookStatus(bookDTO.getBookStatus());
			book.setCreatedBy(jwtTokenUtil.getUserName());
			book.setCreatedDate(new Date());
			book.setUpdatedBy(jwtTokenUtil.getUserName());
			book.setUpdatedDate(new Date());
			bookRepository.save(book);
		}

	}

	@Override
	public List<BookDTO> retriveBooks() {
		List<BookDTO> bookDTOs = new ArrayList<>();
		List<Book> authorsList = bookRepository.findAll();
		Optional.ofNullable(authorsList).
					orElse(Collections.emptyList()).
								stream().
									map(book -> {
											BookDTO bookDTO = new BookDTO	();
											BeanUtils.copyProperties(book, bookDTO);
											return bookDTO;
									}).collect(Collectors.toCollection(()-> bookDTOs));
		return bookDTOs;
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
