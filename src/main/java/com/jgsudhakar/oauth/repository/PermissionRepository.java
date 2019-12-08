/**
 * 
 */
package com.jgsudhakar.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgsudhakar.oauth.entity.Permission;

/**
 * @author Sudhakar Tangellapalli
 * com.jgsudhakar.oauth.repository.PermissionRepository.java
 * 2019-12-07
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
