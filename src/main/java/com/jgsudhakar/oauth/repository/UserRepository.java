/**
 * 
 */
package com.jgsudhakar.oauth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgsudhakar.oauth.entity.UserEntity;

/**
 * @author sudhakar.t
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	public Optional<UserEntity> findByUserName(String userName);
}
