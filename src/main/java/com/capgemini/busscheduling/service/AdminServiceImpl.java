package com.capgemini.busscheduling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.busscheduling.beans.Users;
import com.capgemini.busscheduling.dao.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO dao;
	
	@Override
	public Users register(Users user) {
		return dao.register(user);
	}

	@Override
	public Boolean deleteCustomer(Integer id) {
		return dao.deleteCustomer(id);
	}

	@Override
	public Boolean deleteOwner(Integer id) {
		return dao.deleteCustomer(id);
	}

}
