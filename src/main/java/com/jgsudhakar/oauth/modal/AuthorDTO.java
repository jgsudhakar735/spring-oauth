/**
 * 
 */
package com.jgsudhakar.oauth.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jgsudhakar.oauth.entity.Book;

import lombok.Data;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.modal.AuthorDTO.java
 * 2019-11-25
 */
@Data
public class AuthorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long authorId;
	
	private String authorName;
	
	private String authorEmail;
	
	private String authorStatus;
	
	private List<Book> bookList = new ArrayList<Book>();

}
