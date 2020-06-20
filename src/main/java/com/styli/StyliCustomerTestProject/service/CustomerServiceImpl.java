package com.styli.StyliCustomerTestProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.styli.StyliCustomerTestProject.model.Customer;
import com.styli.StyliCustomerTestProject.repository.CustomerCrudRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerCrudRepository customerCrudRepository;

	@Autowired
	public CustomerServiceImpl(CustomerCrudRepository customerCrudRepository) {
		this.customerCrudRepository = customerCrudRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerCrudRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerByEmail(Customer customer) {
		return customerCrudRepository.findByEmail(customer.getEmail());
	}

}
