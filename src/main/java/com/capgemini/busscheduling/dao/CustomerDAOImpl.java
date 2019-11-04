package com.capgemini.busscheduling.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public Users registerCustomer(Users user) {
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		user.setType("customer");
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
		return user;

	}

	@Override
	public Boolean updateCustomer(Users user) {
		boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Users users = manager.find(Users.class, user.getId());
			users.setName(user.getName());
			users.setEmail(user.getEmail());
			users.setPassword(user.getPassword());
			users.setContact(user.getContact());
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Boolean deleteCustomer(Integer id) {
		boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Users user = manager.find(Users.class, id);
			manager.remove(user);
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Ticket bookTicket(Ticket ticket) {
		Availabilty availability=null;
		ticket.setBookingDateTime(new java.util.Date());
		ticket.setId(BusBookingDAOImpl.id);
		Ticket bookedTicket=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(ticket);
			TypedQuery<Availabilty> availQuery=manager.createQuery("from Availabilty where availDate= :aDate and busId= :bId",Availabilty.class);

			//update num of booked ticket
			availQuery.setParameter("aDate", ticket.getJourneyDate());
			availQuery.setParameter("bId", ticket.getBusId());

			List<Availabilty> availList = availQuery.getResultList();
			availability = availList.get(0);
			availability.setAvailSeat(availability.getAvailSeat()-ticket.getNumOfSeats());

			manager.getTransaction().commit();
			manager.close();

			return ticket;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookedTicket;
	}

	@Override
	public Boolean cancelTicket(Integer bookingId, Integer id) {
		Boolean state=false;
		Ticket ticket=null;
		Availabilty availability=null;
		try{
			EntityManager em = FACTORY.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Ticket> query = em.createQuery("from Ticket where id= :uid and bookingId= :bid", Ticket.class);
			TypedQuery<Availabilty> availQuery=em.createQuery("from Availabilty where availDate= :aDate and busId= :bId",Availabilty.class);
			query.setParameter("uid", id);
			query.setParameter("bid", bookingId);

			List<Ticket> ticketList = query.getResultList();
			if(ticketList.size()>0) {
				ticket = ticketList.get(0);
				em.remove(ticket);

				//increase num of cancelled ticket
				availQuery.setParameter("aDate", ticket.getJourneyDate());
				availQuery.setParameter("bId", ticket.getBusId());

				List<Availabilty> availList = availQuery.getResultList();
				availability = availList.get(0);
				availability.setAvailSeat(availability.getAvailSeat()+ticket.getNumOfSeats());
				state=true;

			}
			em.getTransaction().commit();
			em.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public List<Ticket>  getTicketInfo(Integer bookingId) {
		List<Ticket> ticketLi =null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Ticket> query = manager.createQuery("from Ticket where bookingId= :bid", Ticket.class);
			query.setParameter("bid", bookingId);
			ticketLi = query.getResultList();
			if(ticketLi!=null) {
				return ticketLi;
			}
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ticketLi;
	}

	@Override
	public Boolean writeFeedback(Feedback feed) {
		boolean state = false;
		feed.setId(BusBookingDAOImpl.id);
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(feed);
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

}
