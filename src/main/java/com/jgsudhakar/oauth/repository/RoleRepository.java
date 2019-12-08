/**
 * 
 */
package com.jgsudhakar.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgsudhakar.oauth.entity.Role;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.repository.RoleRepository.java
 * 2019-12-07
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
