package com.ratul.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ratul.web.entities.Course;

@Repository
public class CourseDAOImpl implements CourseDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Course course) {

		String query = "insert into course(course_id,c_name,c_desp,c_fees,c_resource) values(?,?,?,?,?)";
		
		int update = jdbcTemplate.update(query,course.getCourse_id(),course.getC_name(),course.getC_desp(),course.getC_fees(),course.getC_resource());

		return update;
		
	}

}
