package com.ratul.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ratul.web.dao.FeedbackDAO;
import com.ratul.web.dao.UserDAO;
import com.ratul.web.entities.Feedback;
import com.ratul.web.entities.User;

@Controller
public class FeedbackConroller {

	@Autowired
	private FeedbackDAO feedbackDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/feedbackForm")
	public ModelAndView displayUserForm(HttpServletResponse httpResponse) throws IOException {
		
		ModelAndView modelAndView = new ModelAndView("feedbackform");
		
		if(UserController.currentUserID == 0) {
			
			httpResponse.sendRedirect("/userForm");
	        return null;
			
		}
		
		User user = userDAO.get(UserController.currentUserID);
		
		Feedback feedback = new Feedback();
		
		feedback.setUser_id(user.getUser_id());
		feedback.setName(user.getName());
		feedback.setEmail(user.getEmail());
		
		modelAndView.addObject("feedback",feedback);
		
		return modelAndView;
	}
	
	@RequestMapping("/saveFeedbackForm")
	public String saveUser(@ModelAttribute Feedback feedback ) {
		
		feedbackDAO.insert(feedback);
		
		return "redirect:/homepage";
	}
	
}
