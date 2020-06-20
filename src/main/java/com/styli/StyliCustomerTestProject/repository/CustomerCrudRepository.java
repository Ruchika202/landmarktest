/**
 * 
 */
package com.styli.StyliCustomerTestProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.styli.StyliCustomerTestProject.model.Customer;

/**
 * @author Ruchika
 *
 */
public interface CustomerCrudRepository extends CrudRepository<Customer,String>{

	
	List<Customer> findAll();
	Optional<Customer> findByEmail(String email);

}
