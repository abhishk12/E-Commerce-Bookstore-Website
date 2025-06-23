package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO() {
	}
	
	public Users create(Users user) {
		return super.create(user);
	}
	
	@Override
	public Users update(Users user) {
		return super.update(user);

	}

	@Override
	public Users get(Object userId) {
		
		return super.find(Users.class, userId);
	}

	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);
	}

	@Override
	public List<Users> listAll() {
		return super.findWithNamedQuery("users.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("users.countAll");
	}
	
	public Users findByEmail(String email) {
		List<Users> listUsers =  super.findWithNamedQuery("users.findByEmail", "email", email);
		if(listUsers != null && listUsers.size()>0) {
			return listUsers.get(0);
		}
		return null;
	}
	
	public boolean checkLogin(String email, String password) {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		params.put("password", password);
		List<Users> listUsers = super.findWithNamedQuery("users.checkLogin", params);
		
		if(listUsers.size() == 1) {
			return true;
		}
		
		return false;
	}

	
	
}
