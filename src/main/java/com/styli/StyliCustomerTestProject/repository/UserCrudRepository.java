package com.styli.StyliCustomerTestProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.styli.StyliCustomerTestProject.model.User;

@Repository
public interface UserCrudRepository extends CrudRepository<User, String> {
	
	List<User> findAll();
	
	Optional<User> findByEmailAndPassword(String email,String password);

}
