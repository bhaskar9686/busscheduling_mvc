package com.capgemini.busscheduling.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.busscheduling.beans.Availabilty;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Users;

@Repository
public class BusBookingDAOImpl implements BusBookingDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");
	
	static int id;
	@Override
	public Users login(Integer id, String password) {
		
		BusBookingDAOImpl.id = id;
		Users user =null;
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Users> 	query = manager.createQuery("FROM Users WHERE id = :id and password = :password ", Users.class);
		query.setParameter("id", id);
		query.setParameter("password", password);
		List<Users> users = query.getResultList();
		if(users.size() > 0) {
			user = users.get(0);
			manager.getTransaction().commit();
			manager.close();
		}
		return user;
	}
	@Override
	public Bus searchBus(Integer busId) {
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		Bus bus = manager.find(Bus.class, busId);
		return bus;
	}


	@Override
	public List<Availabilty> checkAvailability(String source, String destination, String date) {
		List<Availabilty> availList=new ArrayList<Availabilty>();
		List<Availabilty> resulList=null;
		List<Bus> busList=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Bus> query = manager.createQuery("from Bus where source= :busSource and destination= :busDestination", Bus.class);
			query.setParameter("busSource", source);
			query.setParameter("busDestination", destination);
			busList = query.getResultList();
			TypedQuery<Availabilty> availQuery=manager.createQuery("from Availabilty where busId= :bid and availDate= :aDate",Availabilty.class);
			if(busList.size()>0) {
				for(Bus bus : busList) {
					availQuery.setParameter("bid", bus.getBusId());
					availQuery.setParameter("aDate", date);
					
					//get the result from table 
					resulList=availQuery.getResultList();
					
					//store the Availability in availList
					availList.addAll(resulList);
				}
			}
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return availList;
	}

	@Override
	public List<Feedback> viewFeedback() {
		List<Feedback> feed=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Feedback> query = manager.createQuery("from Feedback ", Feedback.class);
			feed = query.getResultList();
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return feed;
	}

	@Override
	public List<Bus> showAllBuses() {
		List<Bus> buses=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Bus> query = manager.createQuery("from Bus ", Bus.class);
			buses = query.getResultList();
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return buses;
	}

}
