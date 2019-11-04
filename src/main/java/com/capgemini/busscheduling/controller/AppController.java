package com.capgemini.busscheduling.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.busscheduling.beans.Users;
import com.capgemini.busscheduling.service.BusBookingService;

@Controller
public class AppController {

	@Autowired
	BusBookingService bookingService;
	@GetMapping("/homePage")
	public ModelAndView homePage(ModelAndView modelAndView) {
		modelAndView.setViewName("home");
		return modelAndView;
	}// end of homePage()
	
	@GetMapping("/loginPage")
	public ModelAndView getLoginForm(ModelAndView modelAndView) {
		modelAndView.setViewName("loginPage");
		return modelAndView;
	}// end of getLoginForm()

	@PostMapping("/login")
	public String userLogin(int id, String password, HttpServletRequest req) {
		Users user = bookingService.login(id, password);
		
			if(user!=null && user.getType().equals("Admin")) {
				HttpSession session = req.getSession(true);
				session.setMaxInactiveInterval(30);
				session.setAttribute("admin", user);
				return "adminHomePage";
			} else if(user!=null && user.getType().equals("Owner")) {
				HttpSession session = req.getSession(true);
				session.setMaxInactiveInterval(30);
				session.setAttribute("owner", user);
				return "ownerHomePage";
			} else if(user!=null && user.getType().equals("Customer")) {
				HttpSession session = req.getSession(true);
				session.setMaxInactiveInterval(30);
				session.setAttribute("customer", user);
				return "customerHomePage";
		}else {
			req.setAttribute("msg", "Invalid Credentials");
			return "loginPage";
		}
	}// end of userLogin()
}
