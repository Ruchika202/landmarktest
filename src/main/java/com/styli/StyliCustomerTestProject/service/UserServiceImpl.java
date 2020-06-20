package com.styli.StyliCustomerTestProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.styli.StyliCustomerTestProject.model.User;
import com.styli.StyliCustomerTestProject.repository.UserCrudRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserCrudRepository userCrudRepository;

	@Autowired
	public UserServiceImpl(UserCrudRepository userCrudRepository) {
		this.userCrudRepository= userCrudRepository;
	}

	@Override
	public void create(User user) {
		userCrudRepository.save(user);

	}

	@Override
	public boolean checkValidUser(User user) {
		
		return userCrudRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).isPresent();
	}

}
