package com.capgemini.busscheduling.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Ticket;

@Repository
public class OwnerDAOImpl implements OwnerDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public Bus addBus(Bus bus) {
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(bus);
			manager.getTransaction().commit();
			manager.close();
			return bus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updateBus(Bus bus) {
		Boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Bus dbus = manager.find(Bus.class, bus.getBusId());
			dbus.setBusName(bus.getBusName());
			dbus.setBusType(bus.getBusType());
			dbus.setSource(bus.getSource());
			dbus.setDestination(bus.getDestination());
			dbus.setPrice(bus.getPrice());
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			//Custom Exception
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Boolean deleteBus(Integer busId) {
		Boolean state=false;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Bus bus = manager.find(Bus.class, busId);
			manager.remove(bus);
			manager.getTransaction().commit();
			state=true;
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public List<Ticket> getAllTicket() {

		List<Ticket> ticketLi=null; 
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Ticket> query = manager.createQuery("from Ticket", Ticket.class);
			ticketLi = query.getResultList();
			manager.getTransaction().commit();
			manager.close(); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ticketLi;	
	}

	@Override
	public Boolean setBusAvailability(Availabilty availability) {
		Boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(availability);
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
}
