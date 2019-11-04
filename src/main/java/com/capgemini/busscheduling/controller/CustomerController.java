package com.capgemini.busscheduling.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;
import com.capgemini.busscheduling.service.BusBookingService;
import com.capgemini.busscheduling.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	BusBookingService bookingService;
	
	@GetMapping("/updateCustomer")
	public String getUpdateCustomer(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "updateCustomer";
		}
	}// end of getUpdateCustomer() 

	@PostMapping("/updateProfile")
	public String updateCustomer(Users user, ModelMap modelMap) {
		if(customerService.updateCustomer(user)) {
			modelMap.addAttribute("msg", "User Updated Successfully");
		}else {
			modelMap.addAttribute("msg", "Failed to Update User Details");
		}
		return "customerHomePage";
	}// end of updateCustomer() 
	
	@GetMapping("/bookTicket")
	public String getBookingForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
		return"bookTicket";
		}
	}// end of getBookingForm()
	
	@PostMapping("/checkAvailability")
	public String checkAvailability(String source, String destination, String journeyDate, ModelMap modelMap) {
		List<Availabilty> availabilties = bookingService.checkAvailability(source, destination, journeyDate);
	
		 if(availabilties != null) {
			 modelMap.addAttribute("availList", availabilties);
		 } else {
			 modelMap.addAttribute("msg", "No Bus Found");
		 }
		 return "bookTicket";
	}// end of checkAvailability()
	
	@PostMapping("/bookTicket")
	public String bookTicket(int id, int busId, String journeyDate, int numOfSeats, ModelMap modelMap) {
		 Ticket ticket = new Ticket();
		 ticket.setId(id);
		 ticket.setBusId(busId);
		 ticket.setJourneyDate(journeyDate);
		 ticket.setNumOfSeats(numOfSeats);
		 
		 Ticket bookedTicket = customerService.bookTicket(ticket);
		 if(bookedTicket!= null) {
			 modelMap.addAttribute("ticket", bookedTicket);
		 } else {
			 modelMap.addAttribute("msg", "Failed to Book Ticket"); 
		 }
		 return "bookTicket";
	}// end of bookTicket()
	
	@GetMapping("/cancelTicket")
	public String getCancelTicket(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
		return"cancelTicket";
		}
	}// end of getCancelTicket()
	
	@PostMapping("/ticketCancel")
	public String cancelTicket(int id, int bookingId, ModelMap modelMap) {
		if(customerService.cancelTicket(bookingId, id)) {
			modelMap.addAttribute("msg", "Ticket Cancelled Successfully");
		} else {
			modelMap.addAttribute("msg", "Failed to Canceled Ticket");
		}
		return "customerHomePage";
	}// end of cancelTicket()
	
	@GetMapping("/getTicket")
	public String getTicketInfoForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
		return"getTicketInfoForm";
		}
	}// end of getTicketInfoForm()
	
	@PostMapping("/getTicket")
	public String getTicketInfo(int bookingId, ModelMap modelMap) {
		List<Ticket> ticket = customerService.getTicketInfo(bookingId);
		if(ticket !=null) {
			modelMap.addAttribute("ticketList", ticket);
		} else {
			modelMap.addAttribute("msg", "Ticket Not Found");
		}
		return "getAllTickets";
	}// end of getTicketInfo()
	
	@GetMapping("/giveFeedback")
	public String getFeedbackForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "feedbackForm";
		}
	}// end of getFeedbackForm()

	@PostMapping("/giveFeedback")
	public String register(Feedback feed, ModelMap modelMap) {
		if(customerService.writeFeedback(feed)) {
			modelMap.addAttribute("msg", "Thank you!!");
		}else {
			modelMap.addAttribute("msg", "Failed to give feedback please try again ");
		}
		return "customerHomePage";
	}// end of register()
}
