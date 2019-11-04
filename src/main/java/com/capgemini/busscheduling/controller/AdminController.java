package com.capgemini.busscheduling.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.busscheduling.beans.Users;
import com.capgemini.busscheduling.service.AdminService;

@Controller
//@CrossOrigin(origins="*",allowedHeaders = "*",allowCredentials = "true")
public class AdminController {

	@Autowired
	AdminService adminservice;

	@GetMapping("/addUser")
	public String getRegisterForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "register";
		}
	}// end of getRegisterForm()

	@PostMapping("/addUser")
	public String register(Users user, ModelMap modelMap) {
		user =adminservice.register(user);
		if(user!=null) {
			modelMap.addAttribute("msg", "User Added Successfully");
		}else {
			modelMap.addAttribute("msg", "User Already Exist ");
		}
		return "adminHomePage";
	}// end of register()

	@GetMapping("/deleteOwner")
	public String getDeleteOwner(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "deleteOwner";
		}
	}//end of getDeleteOwner()

	@PostMapping("/deleteOwner")
	public String deleteOwner(int id,ModelMap modelMap ) {
		if(adminservice.deleteOwner(id)) {
			modelMap.addAttribute("msg", "Owner Deleted Successfully");
		}else {
			modelMap.addAttribute("msg", "Failed Delete to Owner");
		}
		return "adminHomePage";
	}//end of deleteOwner()

	@GetMapping("/deleteCustomer")
	public String getDeleteCustomer(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "deleteCustomer";
		}
	}// end of getDeleteCustomer()

	@PostMapping("/deleteCustomer")
	public String deleteCustomer(int id,ModelMap modelMap ) {
		if(adminservice.deleteCustomer(id)) {
			modelMap.addAttribute("msg", "Customer Deleted Successfully");
		}else {
			modelMap.addAttribute("msg", "Failed to Delete Customer");
		}
		return "adminHomePage";
	}// end of deleteCustomer()

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("msg", "You Are Successfully Logged Out!");
		return "forward:/loginPage";
	}// End of logout()
}