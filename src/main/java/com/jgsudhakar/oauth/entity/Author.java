/**
 * 
 */
package com.jgsudhakar.oauth.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.entity.Author.java
 * 2019-11-25
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Author extends CommonEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTHOR_ID")
	private Long authorId;
	
	@Column(name = "AUTHOR_NAME")
	private String authorName;
	
	@Column(name = "AUTHOR_EMAIL")
	private String authorEmail;
	
	@Column(name = "AUTHOR_STATUS")
	private String authorStatus;
	
	@Basic(fetch=FetchType.EAGER)
	@OneToMany(mappedBy="author",fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Book> bookList = new ArrayList<Book>();
}
