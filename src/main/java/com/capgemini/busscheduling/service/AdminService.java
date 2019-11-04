package com.capgemini.busscheduling.service;

import com.capgemini.busscheduling.beans.Users;

public interface AdminService {
	
	public Users register( Users user);
	public Boolean deleteCustomer(Integer id);
	public Boolean deleteOwner(Integer id);
}
