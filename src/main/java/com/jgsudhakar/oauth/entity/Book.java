/**
 * 
 */
package com.jgsudhakar.oauth.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.entity.Book.java
 * 2019-11-25
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Book extends CommonEntity implements Serializable{

	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = 4039242600298566365L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
	private Long bookId;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "book_status")
	private String bookStatus;
	
	@Column(name = "author_id", insertable = false, updatable = false)
	private Long authorId;
	
	/** The mxim user mtb. */
	@Basic(fetch=FetchType.LAZY)
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="AUTHOR_ID",referencedColumnName="AUTHOR_ID")
	private Author author;
}
