package com.ratul.web.dao;

import java.util.List;

import com.ratul.web.entities.User;

public interface UserDAO {

	public int insert(User user);
	
	public List<User> get();
	
	public User get(int user_id);
	
}
