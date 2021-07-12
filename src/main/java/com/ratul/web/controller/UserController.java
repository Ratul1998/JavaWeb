package com.ratul.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ratul.web.dao.UserDAO;
import com.ratul.web.entities.User;

@Controller
public class UserController {
	
	public static int currentUserID =0;
	
	@Autowired
	private UserDAO userDAO;

	
	@RequestMapping("/authenticateUser")
	public String authenticateUser(@ModelAttribute User user , RedirectAttributes redirectAttributes) {
		
		User u = userDAO.get(user.getUser_id());
		
		if(u!=null) {
			
			if(u.getPassword().equals(user.getPassword())) {
				
				currentUserID = u.getUser_id();
				
				return "redirect:/homepage";
				
			}
			else {
				
				redirectAttributes.addAttribute("message", "Incorrect Password");
				return "redirect:/userForm";
				
			}
			
		}
		
		redirectAttributes.addAttribute("message", "User Not Found");
		return "redirect:/userForm";
	}
	
	@RequestMapping("/userForm")
	public ModelAndView displayUserForm(@RequestParam(value = "message", required = false) String message) {
		
		ModelAndView modelAndView = new ModelAndView("userRegistration");
		
		System.out.println("Message : " + message);
		
		modelAndView.addObject("message",message);
		
		modelAndView.addObject("user",new User());
		
		return modelAndView;
	}
	
	@RequestMapping("/homepage")
	public ModelAndView displayHomepage(HttpServletResponse httpResponse) throws IOException {
		
		ModelAndView modelAndView = new ModelAndView("homepage");
		
		if(currentUserID == 0) {
			
			httpResponse.sendRedirect("/userForm");
	        return null;
			
		}
		
		User user = userDAO.get(currentUserID);
		
		System.out.println(user.toString());
		
		modelAndView.addObject("user",user);
		
		return modelAndView;
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute User user ) {
		
		currentUserID = userDAO.insert(user);
		
		return "redirect:/homepage";
	}

	@RequestMapping("/openContactForm")
	public String openContactForm() {
		
		return "redirect:/contactForm";
	}
	
	@RequestMapping("/openCourseForm")
	public String openCourseForm() {
		
		return "redirect:/corseForm";
	}
	
	@RequestMapping("/openFeedbackForm")
	public String openFeedbackForm() {
		
		return "redirect:/feedbackForm";
	}
	
}
