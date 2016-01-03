/**
 * 
 */
package com.happydesk.entity;

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
public class User extends BaseEntity<Integer> implements Serializable{

	private static final long serialVersionUID = -5952231633736953084L;

	 @Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	 @Column(name = "id")  
	 private Integer Id;  
	
	@Column(name="email")  
	 private String email;
	
	@Column(name="password")  
	 private String password;
	
	
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
	   
	 public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
}
