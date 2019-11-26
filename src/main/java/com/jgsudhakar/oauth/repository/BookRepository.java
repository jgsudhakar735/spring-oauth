/**
 * 
 */
package com.jgsudhakar.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgsudhakar.oauth.entity.Book;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.repository.BookRepository.java
 * 2019-11-25
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
