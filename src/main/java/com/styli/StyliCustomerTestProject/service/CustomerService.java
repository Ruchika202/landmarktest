package com.styli.StyliCustomerTestProject.service;

import java.util.List;
import java.util.Optional;

import com.styli.StyliCustomerTestProject.model.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	
	Optional<Customer> getCustomerByEmail(Customer customer);
}
