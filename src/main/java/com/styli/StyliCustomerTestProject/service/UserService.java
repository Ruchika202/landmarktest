package com.styli.StyliCustomerTestProject.service;

import com.styli.StyliCustomerTestProject.model.User;

public interface UserService {
	
	void create(User user);
	
	boolean checkValidUser(User user);

}
