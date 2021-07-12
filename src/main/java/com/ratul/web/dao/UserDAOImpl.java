package com.ratul.web.dao;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ratul.web.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(User user) {

		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String query = "insert into user1(user_id,name,phone_no,email,password,address,reg_date,upload_photo) values(userid.nextval,?,?,?,?,?,?,?)";

		 jdbcTemplate.update(connection -> { 
			 
	     PreparedStatement ps = connection.prepareStatement(query,new String[] {"user_id"}); 
		 ps.setString(1, user.getName()); 
		 ps.setLong(2, user.getPhone_no()); 
		 ps.setString(3, user.getEmail()); 
		 ps.setString(4, user.getPassword()); 
		 ps.setString(5, user.getAddress());
		 ps.setDate(6, sqlDate); 
		 ps.setString(7, user.getUpload_photo());
		 return ps; },
		 keyHolder);
	
		 int userID = Integer.parseInt(keyHolder.getKey().toString());
		 

		return userID;
	}

	@Override
	public List<User> get() {

		String sql = "SELECT * FROM USER1";

		List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));

		return users;
	}

	@Override
	public User get(int user_id) {
		
		String sql = "SELECT * FROM USER1 where user_id =" + user_id;
		
		List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
		
		if(users!=null && !users.isEmpty())
			return users.get(0);
		return null;
		
	}

}
