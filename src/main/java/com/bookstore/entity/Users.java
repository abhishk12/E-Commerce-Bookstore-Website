package com.bookstore.entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="users")
@Table(name="users")
@NamedQueries({
	@NamedQuery(name = "users.findAll", query = "SELECT u FROM users u ORDER BY u.full_name"),
	@NamedQuery(name = "users.countAll", query = "SELECT COUNT(*) FROM users"),
	@NamedQuery(name= "users.findByEmail", query = "SELECT u FROM users u WHERE u.email= :email"),
	@NamedQuery(name= "users.checkLogin", query = "SELECT u FROM users u WHERE u.email= :email AND password= :password")
})
public class Users implements java.io.Serializable{

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="full_name")
	private String full_name;
	
	@Column(name="password")
	private String password;
	
	
	
	public Users(int user_id, String email, String full_name, String password) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.full_name = full_name;
		this.password = password;
	}

	public Users(String email, String full_name, String password) {
		super();
		this.email = email;
		this.full_name = full_name;
		this.password = password;
	}
	
	public Users() {
		super();
		this.email = "default";
		this.full_name = "default";
		this.password = "default";
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
