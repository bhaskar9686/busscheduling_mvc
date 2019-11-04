package com.capgemini.busscheduling.service;

import java.util.List;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Ticket;

public interface OwnerService {
	public Bus addBus(Bus bus);
	public Boolean updateBus(Bus bus);
	public Boolean deleteBus(Integer busId);
	public List<Ticket>getAllTicket();
	public Boolean setBusAvailability(Availabilty availability);
}
