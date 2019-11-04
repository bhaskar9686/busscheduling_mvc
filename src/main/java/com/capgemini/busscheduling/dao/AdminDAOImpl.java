package com.capgemini.busscheduling.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.capgemini.busscheduling.beans.Users;

@Repository
public class AdminDAOImpl implements AdminDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public Users register(Users user) {
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
		return user;
	}
	
	@Override
	public Boolean deleteCustomer(Integer id) {
		boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Users user = manager.find(Users.class, id);
			if(user.getType().equals("Customer")) {
			manager.remove(user);
			manager.getTransaction().commit();
			manager.close();
			state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	@Override
	public Boolean deleteOwner(Integer id) {
		boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Users user  = manager.find(Users.class, id);
			if(user.getType().equals("Owner")) {
			manager.remove(user);
			manager.getTransaction().commit();
			manager.close();
			state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}


}
