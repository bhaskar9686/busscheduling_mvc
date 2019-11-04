package com.capgemini.busscheduling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Users;
import com.capgemini.busscheduling.dao.BusBookingDAO;

@Service
public class BusBookingServiceImpl implements BusBookingService {

	@Autowired
	BusBookingDAO dao;
	
	@Override
	public Users login(Integer id, String password) {
		return dao.login(id, password);
	}

	@Override
	public Bus searchBus(Integer busId) {
		return dao.searchBus(busId);
	}

	@Override
	public List<Bus> showAllBuses() {
		return dao.showAllBuses();
	}


	@Override
	public List<Availabilty> checkAvailability(String source, String destination, String tempDate) {
		return dao.checkAvailability(source, destination, tempDate);
	}

	@Override
	public List<Feedback> viewFeedback() {
		return dao.viewFeedback();
	}

}
