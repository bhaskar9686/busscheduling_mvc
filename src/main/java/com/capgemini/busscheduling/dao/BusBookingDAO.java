package com.capgemini.busscheduling.dao;

import java.util.List;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Users;

public interface BusBookingDAO {

	public Bus searchBus(Integer busId);
	public Users login(Integer id, String password);
	public List<Bus> showAllBuses();
	public List<Availabilty>checkAvailability(String source, String destination, String date);
	public List<Feedback> viewFeedback();
}
