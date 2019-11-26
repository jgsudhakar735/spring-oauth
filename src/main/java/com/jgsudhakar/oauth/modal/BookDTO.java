/**
 * 
 */
package com.jgsudhakar.oauth.modal;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.modal.BookDTO.java
 * 2019-11-25
 */
@Data
public class BookDTO implements Serializable{

	/**
	 *Default Serial ID 
	 */
	private static final long serialVersionUID = 1L;

	private Long bookId;
	
	private String bookName;
	
	private String bookStatus;
	
	private Long authorId;
	
	private AuthorDTO author;		
}
