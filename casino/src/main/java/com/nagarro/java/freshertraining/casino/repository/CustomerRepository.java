package com.nagarro.java.freshertraining.casino.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.java.freshertraining.casino.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

	public Customer findByemail(String emailId);
}
