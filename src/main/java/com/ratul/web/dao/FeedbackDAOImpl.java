package com.ratul.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ratul.web.entities.Feedback;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Feedback feedback) {

		String query = "insert into feedback(f_id,user_id,name,email,feedback) values(feedbackid.nextval,?,?,?,?)";
		
		int update = jdbcTemplate.update(query,feedback.getUser_id(),feedback.getName(),feedback.getEmail(),feedback.getFeedback());

		return update;
		
	}

	
}
