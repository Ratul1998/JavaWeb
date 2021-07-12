package com.ratul.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ratul.web.entities.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public int insert(Contact contact) {
		
		String query = "insert into contact(user_id,name,phone_no,email,messege,contact_id) values(?,?,?,?,?,?)";
		
		int update = jdbcTemplate.update(query,contact.getUser_id(),contact.getName(),contact.getPhone_no(),contact.getEmail(),contact.getMessege(),0);

		return update;
		
	}

}
