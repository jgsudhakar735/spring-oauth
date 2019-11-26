/**
 * 
 */
package com.jgsudhakar.oauth.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgsudhakar.oauth.entity.Author;
import com.jgsudhakar.oauth.entity.Book;
import com.jgsudhakar.oauth.modal.AuthorDTO;
import com.jgsudhakar.oauth.repository.AuthorRepository;
import com.jgsudhakar.oauth.service.AuthorService;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.service.impl.AuthorServiceImpl.java
 * 2019-11-25
 */
@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public void saveAuthor(AuthorDTO authorDTO) {
		Author author = constructEntityObject(authorDTO);
		authorRepository.save(author);
	}

	/**
	 * @param authorDTO
	 * @return
	 */
	private Author constructEntityObject(AuthorDTO authorDTO) {
		Author author = new Author();
		author.setAuthorName(authorDTO.getAuthorName());
		author.setAuthorEmail(authorDTO.getAuthorEmail());
		author.setAuthorStatus(authorDTO.getAuthorStatus());
		if(CollectionUtils.isNotEmpty(authorDTO.getBookList())) {
			authorDTO.getBookList().stream().map(bookDto -> {
				Book book = new Book();
				book.setAuthor(author);
				book.setBookName(bookDto.getBookName());
				book.setBookStatus(bookDto.getBookStatus());
				return book;
			}).collect(Collectors.toCollection(() -> author.getBookList()));
		}
		return author;
	}

	@Override
	public List<AuthorDTO> retriveAuthors() {
		List<AuthorDTO> authorDTOs = new ArrayList<>();
		List<Author> authorsList = authorRepository.findAll();
		Optional.ofNullable(authorsList).
					orElse(Collections.emptyList()).
								stream().
									map(author -> {
											AuthorDTO authorDTO = new AuthorDTO();
											return authorDTO;
									}).collect(Collectors.toCollection(()-> authorDTOs));
		return null;
	}

	@Override
	public AuthorDTO getAuthorDetails(Long authorId) {
		return null;
	}

	@Override
	public List<AuthorDTO> getAuthorsList(String authorName) {
		return null;
	}

	@Override
	public void deleteAuthor(Long authorId) {

	}

	@Override
	public void updateAuthor(AuthorDTO authorDTO) {

	}

}
