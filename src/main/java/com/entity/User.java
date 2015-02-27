package com.entity;

import java.io.Serializable;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
=======
import javax.persistence.*;
>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String password;

	@Column(name="user_type")
	private String userType;

	private String username;

	public User() {
	}
	
	public User(String name, String username, String password, String userType){
		this.name = name;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
<<<<<<< HEAD
=======

>>>>>>> d1ca346c5313165f298de19b2f765d6cc3010c68
}