package com.capgemini.busscheduling.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.service.BusBookingService;

@Controller
public class BusController {
	
	@Autowired
	BusBookingService bookingService;
	
	@GetMapping("/searchBus")
	public String getSearchBusForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "searchBusForm";
		}
	}// end of getSearchBusForm()

	@PostMapping("/searchBus")
	public String searchBus(Integer busId, ModelMap modelMap) {
		Bus bus = bookingService.searchBus(busId);
		if(bus!=null) {
			modelMap.addAttribute("bus", bus);
		}else {
			modelMap.addAttribute("msg", "Bus Not Found");
		}
		return "showAllBusForm";
	}// end of searchBus()
	
	@GetMapping("/viewBus")
	public String getTicketForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			List<Bus> buses = bookingService.showAllBuses();
			modelMap.addAttribute("buses", buses);
			return "showAllBusForm";
		}
	}// end of getTicketForm()
	
	@GetMapping("/checkAvailability")
	public String getAvailabilityForm(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginPage";
		} else {
			return "checkAvailabilityForm";
		}
	}// end of getAvailabilityForm()
	
//	@PostMapping("/checkAvailability")
//	public String checkAvailability(int busId, String date, ModelMap modelMap ) {
//		Integer seats = bookingService.checkAvailability(busId, date);
//		if(seats!=null) {
//			modelMap.addAttribute("seats", seats);
//		} else {
//			modelMap.addAttribute("msg", "No Seats Available");
//		}
//		return "checkAvailabilityForm";
//	}
}
