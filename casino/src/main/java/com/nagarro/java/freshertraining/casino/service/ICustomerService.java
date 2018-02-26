package com.nagarro.java.freshertraining.casino.service;

import java.util.List;

import com.nagarro.java.freshertraining.casino.exception.ServiceException;
import com.nagarro.java.freshertraining.casino.model.Customer;

/**
 * ICustomerService give all the required services for customer
 *
 * @author rahulagarwal
 *
 */
public interface ICustomerService {

	/**
	 * This method get all the customers
	 *
	 * @return List of Customers
	 * @throws ServiceException
	 */
	List<Customer> getAllCustomers() throws ServiceException;

	/**
	 * this method get Customer with its Unique Identity
	 *
	 * @param id
	 * @return Customer
	 * @throws ServiceException
	 */
	Customer getCustomer(String id) throws ServiceException;

	/**
	 * This method add customer to database
	 *
	 * @param customer
	 * @return
	 * @throws ServiceException
	 */
	String addCustomer(Customer customer) throws ServiceException;

	/**
	 * This method updates balance of customer
	 *
	 * @param balance
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	String updateBalance(long balance, String id) throws ServiceException;

	/**
	 * This method adjust amount of customer in database
	 *
	 * @param win_amount
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	String adjustAmount(long win_amount, String id) throws ServiceException;

	/**
	 * This method block amount of customer in database
	 *
	 * @param blockedAmount
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	String blockAmount(long blockedAmount, String id) throws ServiceException;

	/**
	 * This method get customer with its unique Email_ID
	 * 
	 * @param emailId
	 * @return Customer
	 * @throws ServiceException
	 */
	Customer getCustomerByEmailId(String emailId) throws ServiceException;

}