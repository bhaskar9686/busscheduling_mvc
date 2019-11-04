package com.capgemini.busscheduling.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.service.OwnerService;

@Controller
public class OwnerController {

	@Autowired
	OwnerService ownerService;

	@GetMapping("/addBus")
	public String getOwnerRegisterForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "addBus";
		}
	}// end of getRegisterForm()

	@PostMapping("/addBus")
	public String registerBus(Bus bus, ModelMap modelMap) {
		bus =ownerService.addBus(bus);
		if(bus!=null) {
			modelMap.addAttribute("msg", "Bus Added Successfully");
		}else {
			modelMap.addAttribute("msg", "Bus Id Already Exist ");
		}
		return "ownerHomePage";
	}// end of register()
	
	@GetMapping("/updateBus")
	public String getUpdateBus(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "updateBusForm";
		}
	}// end of getUpdateBus() 

	@PostMapping("/updateBus")
	public String updateBus(Bus bus, ModelMap modelMap) {
		if(ownerService.updateBus(bus)) {
			modelMap.addAttribute("msg", "Bus Updated Successfully");
		}else {
			modelMap.addAttribute("msg", "Failed to Update Bus Details");
		}
		return "ownerHomePage";
	}// end of updateBus() 
	
	@GetMapping("/deleteBus")
	public String getDeleteBus(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "deleteBus";
		}
	}//end of getDeleteOwner()
	
	@PostMapping("/deleteBus")
	public String deleteBus(Integer busId,ModelMap modelMap ) {
		if(ownerService.deleteBus(busId)) {
			modelMap.addAttribute("msg", "Bus Deleted Successfully");
		}else {
			modelMap.addAttribute("msg", "Failed to Delete Bus");
		}
		return "ownerHomePage";
	}//end of deleteOwner()
	
	@GetMapping("/getTickets")
	public String getTicketForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			List<Ticket> tickets = ownerService.getAllTicket();
			modelMap.addAttribute("ticketList", tickets);
			return "getAllTickets";
		}
	}// end of getTicketForm()
	
	
	
	@GetMapping("/setAvailabilty")
	public String getSetAvailability(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		}else {
			return "setAvailability";
		}
	}// end of getSetAvailability()
	
	@PostMapping("/setAvailability")
	public String setAvailability(Availabilty availabilty,ModelMap modelMap) {
		if(ownerService.setBusAvailability(availabilty)) {
			modelMap.addAttribute("msg", "Successfully Updated Availability");
		}else {
			modelMap.addAttribute("msg", "Failed to set Availability");
		}
		return "ownerHomePage";
	}// end of setAvailability()
	
}