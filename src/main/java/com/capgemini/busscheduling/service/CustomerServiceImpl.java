package com.capgemini.busscheduling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;
import com.capgemini.busscheduling.dao.BusBookingDAO;
import com.capgemini.busscheduling.dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO dao;
	@Autowired
	BusBookingDAO busDao;
	@Override
	public Users registerCustomer(Users user) {
		return dao.registerCustomer(user);
	}

	@Override
	public Boolean updateCustomer(Users user) {
		return dao.updateCustomer(user);
	}

	@Override
	public Boolean deleteCustomer(Integer id) {
		return dao.deleteCustomer(id);
	}

	@Override
	public Ticket bookTicket(Ticket ticket) {
		return dao.bookTicket(ticket);
	}

	@Override
	public Boolean cancelTicket(Integer bookingId, Integer id) {
		return dao.cancelTicket(bookingId, id);
	}

	@Override
	public List<Ticket> getTicketInfo(Integer bookingId) {
		return dao.getTicketInfo(bookingId);
	}

	@Override
	public List<Availabilty> checkAvailability(String source, String destination, String date) {
		return busDao.checkAvailability(source, destination, date);
	}

	@Override
	public Boolean writeFeedback(Feedback feed) {
		return dao.writeFeedback(feed);
	}



}
