package com.jgsudhakar.oauth.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ROLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable{
	
	/**
	 * Default Seriable ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int roleId;

    @Column(name = "name")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role" ,
    					joinColumns = {
    							@JoinColumn(referencedColumnName = "id" , name = "role_id")
    					}, inverseJoinColumns = {
    							@JoinColumn(referencedColumnName = "id", name = "permission_id")
    					})
    private List<Permission> permissions;
}
