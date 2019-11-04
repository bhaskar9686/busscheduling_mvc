package com.capgemini.busscheduling.dao;

import java.util.List;

import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;

public interface CustomerDAO {
	public Users registerCustomer( Users users);
	public Boolean updateCustomer(Users users);
	public Boolean deleteCustomer(Integer id);
	public Ticket bookTicket(Ticket ticket);
	public Boolean cancelTicket(Integer bookingId, Integer id);
	public List<Ticket> getTicketInfo(Integer bookingId);
	public Boolean writeFeedback(Feedback feed);
}
