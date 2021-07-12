package com.ratul.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ratul.web.dao.CourseDAO;
import com.ratul.web.entities.Course;

@Controller
public class CourseController {

	@Autowired
	private CourseDAO courseDAO;
	
	@RequestMapping("/corseForm")
	public ModelAndView displayUserForm(HttpServletResponse httpResponse) throws IOException {
		
		ModelAndView modelAndView = new ModelAndView("coursesform");
		
		if(UserController.currentUserID == 0) {
			
			httpResponse.sendRedirect("/userForm");
	        return null;
			
		}
		
		modelAndView.addObject("course",new Course());
		
		return modelAndView;
	}
	
	@RequestMapping("/saveCourseForm")
	public String saveUser(@ModelAttribute Course course ) {
		
		courseDAO.insert(course);
		
		return "redirect:/homepage";
	}
	
}
