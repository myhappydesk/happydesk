/**
 * 
 */
package com.happydesk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Manu
 *
 */
@Entity
@Table(name="user")
public class User extends Domain<Integer> implements Serializable{

	@Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	 @Column(name = "id")  
	 private Integer Id;  
	 
	@Column(name="username")  
	 private String username;
	
	@Column(name="email")  
	 private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="password")  
	 private String password;
	
	   
	 public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	 
}
