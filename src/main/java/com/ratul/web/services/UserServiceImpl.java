package com.ratul.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ratul.web.entities.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	@Override
	public int insert(User user) {


		String query = "insert into user1(user_id,name,address) values(userid.nextval,?,?)";
		
		int update = jdbcTemplate.update(query,user.getName(),user.getAddress());
		
		return update;
	}

	
	
}
