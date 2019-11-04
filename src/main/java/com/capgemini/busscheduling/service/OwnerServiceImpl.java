package com.capgemini.busscheduling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.dao.OwnerDAO;

@Service
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	OwnerDAO dao;

	@Override
	public Bus addBus(Bus bus) {
		return dao.addBus(bus);
	}

	@Override
	public Boolean updateBus(Bus bus) {
		return dao.updateBus(bus);
	}

	@Override
	public Boolean deleteBus(Integer busId) {
		return dao.deleteBus(busId);
	}

	@Override
	public List<Ticket> getAllTicket() {
		return dao.getAllTicket();
	}

	@Override
	public Boolean setBusAvailability(Availabilty availability) {
		return dao.setBusAvailability(availability);
	}

}
