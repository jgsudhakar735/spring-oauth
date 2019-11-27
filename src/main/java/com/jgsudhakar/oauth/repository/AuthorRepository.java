/**
 * 
 */
package com.jgsudhakar.oauth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgsudhakar.oauth.entity.Author;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.repository.AuthorRepository.java
 * 2019-11-25
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	public List<Author> findByAuthorName(String userName);
}
