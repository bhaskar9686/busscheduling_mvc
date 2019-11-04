package com.capgemini.busscheduling.service;

import java.util.List;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;

public interface CustomerService {
	public Users registerCustomer( Users user);
	public Boolean updateCustomer(Users user);
	public Boolean deleteCustomer(Integer id);
	public Ticket bookTicket(Ticket ticket);
	public Boolean cancelTicket(Integer bookingId, Integer id);
	public List<Ticket> getTicketInfo(Integer bookingId);
	public List<Availabilty>checkAvailability(String source, String destination, String date);
	public Boolean writeFeedback(Feedback feed);
}
