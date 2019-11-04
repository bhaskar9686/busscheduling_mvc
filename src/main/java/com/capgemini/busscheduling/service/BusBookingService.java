package com.capgemini.busscheduling.service;

import java.util.List;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Users;

public interface BusBookingService {
	
	public Users login(Integer id, String password);
	public Bus searchBus(Integer busId);
	public List<Bus> showAllBuses();
	public List<Availabilty>checkAvailability(String source, String destination, String tempDate);
	public List<Feedback> viewFeedback();
}
