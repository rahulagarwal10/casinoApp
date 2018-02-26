package com.nagarro.java.freshertraining.casino.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nagarro.java.freshertraining.casino.exception.ServiceException;
import com.nagarro.java.freshertraining.casino.model.Customer;
import com.nagarro.java.freshertraining.casino.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	public static final String INITIALBALANCE = "${default.initial.customer.balance}";
	public static final String SERVICE_ERROR = "Service Error";
	public static final String UPDATE_FAILED = "Failed To Update";
	public static final String BLOCK_FAILED = "Failed To Block";
	public static final String ADJUST_FAILED = "Failed To Adjust";
	public static final String ADJUST_AMOUNT = "Amount Adjusted";
	public static final String BLOCK_AMOUNT = "Amount Blocked";
	public static final String UPDATE_BALANCE = "Balance Updated";

	@Autowired
	private CustomerRepository customerRepository;

	@Value(INITIALBALANCE)
	private Long initialBalance;

	@Override
	public List<Customer> getAllCustomers() throws ServiceException {
		try {
			List<Customer> customers = new ArrayList<>();
			customerRepository.findAll().forEach(customers::add);
			return customers;
		} catch (Exception e) {
			throw new ServiceException(SERVICE_ERROR);
		}
	}

	@Override
	public Customer getCustomer(String id) throws ServiceException {
		try {
			return customerRepository.findOne(id);
		} catch (Exception e) {
			throw new ServiceException(SERVICE_ERROR);
		}
	}

	@Override
	@Transactional
	public String addCustomer(Customer customer) throws ServiceException {
		try {

			customer.setUniqueId(UUID.randomUUID().toString().split("-")[0]);
			customer.setBalance(initialBalance);
			customer.setBlockedAmount(0L);
			customerRepository.save(customer);
		} catch (Exception e) {
			throw new ServiceException(SERVICE_ERROR);
		}
		return customer.getUniqueId();
	}

	@Override
	@Transactional
	public String updateBalance(long balance, String id) throws ServiceException {
		try {
			Customer customer = customerRepository.findOne(id);
			customer.setBalance(customer.getBalance() + balance);
			customerRepository.save(customer);
		} catch (Exception e) {
			throw new ServiceException(UPDATE_FAILED);
		}
		return UPDATE_BALANCE;
	}

	@Override
	@Transactional
	public String adjustAmount(long win_amount, String id) throws ServiceException {
		String retVal = "";
		try {
			Customer customer = customerRepository.findOne(id);
			customer.setBalance(customer.getBalance() + win_amount + customer.getBlockedAmount());
			customer.setBlockedAmount(0);
			customerRepository.save(customer);
			retVal = ADJUST_AMOUNT;

		} catch (Exception e) {
			throw new ServiceException(ADJUST_FAILED);

		}
		return retVal;
	}

	@Override
	@Transactional
	public String blockAmount(long blockedAmount, String id) throws ServiceException {
		String retVal = "";
		try {
			Customer customer = customerRepository.findOne(id);
			customer.setBalance(customer.getBalance() - blockedAmount);
			customer.setBlockedAmount(blockedAmount);
			customerRepository.save(customer);
			retVal = BLOCK_AMOUNT;
		} catch (Exception e) {
			throw new ServiceException(BLOCK_FAILED);
		}
		return retVal;
	}

	@Override
	public Customer getCustomerByEmailId(String emailId) throws ServiceException {

		try {
			return customerRepository.findByemail(emailId);
		} catch (Exception e) {
			throw new ServiceException(SERVICE_ERROR);
		}
	}
}
