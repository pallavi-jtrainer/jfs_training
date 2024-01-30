package com.springpeople.spring.boot.data.SpringBootDataJpaDemo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/***
 * @author Pallavi Prasad
 * 
 */
@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "role_name")
	private String roleName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Set<Users> users;
	
	public Roles() {}

	public String getRoleName() {
		return roleName;
	}

	/***
	 * setting the role name.
	 * @param roleName string, sets role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Roles(String roleName) {
		this.roleName = roleName;
	}
	
	public Roles(String roleName, Set<Users> users) {
		this.roleName = roleName;
		this.users = users;
	}
	
	@Override
	public String toString() {
		return "Roles [id=" + id + ", roleName=" + roleName + ", users=" + users + "]";
	}
}
