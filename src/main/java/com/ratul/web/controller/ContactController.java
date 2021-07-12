package com.ratul.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ratul.web.dao.ContactDAO;
import com.ratul.web.dao.UserDAO;
import com.ratul.web.entities.Contact;
import com.ratul.web.entities.User;

@Controller
public class ContactController {

	@Autowired
	private ContactDAO contactDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/contactForm")
	public ModelAndView displayUserForm(HttpServletResponse httpResponse) throws IOException {
		
		ModelAndView modelAndView = new ModelAndView("contactform");
		
		if(UserController.currentUserID == 0) {
			
			httpResponse.sendRedirect("/userForm");
	        return null;
			
		}
		
		
		User user = userDAO.get(UserController.currentUserID);
		
		Contact contact = new Contact();
		
		contact.setUser_id(user.getUser_id());
		contact.setName(user.getName());
		contact.setEmail(user.getEmail());
		contact.setPhone_no(user.getPhone_no());
		
		modelAndView.addObject("contact",contact);
		
		return modelAndView;
	}
	
	@RequestMapping("/saveContactForm")
	public String saveUser(@ModelAttribute Contact contact ) {
		
		contactDAO.insert(contact);
		
		return "redirect:/homepage";
	}
	
}
