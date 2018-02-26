package com.nagarro.java.freshertraining.casino.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.java.freshertraining.casino.exception.ServiceException;
import com.nagarro.java.freshertraining.casino.model.Customer;
import com.nagarro.java.freshertraining.casino.service.ICustomerService;
import com.nagarro.java.freshertraining.casino.validation.CustomerValidator;

/**
 * This class controls all the operations related to customer
 *
 * @author rahulagarwal
 *
 */
@RestController
@CrossOrigin
public class CustomerController {
	public static final String CUSTOMERS_PATH = "/customers";
	public static final String GETCUSTOMER_PATH = "/getcustomer";
	public static final String SETBLOCKEDAMOUNT_PATH = "/setBlockedAmount";
	public static final String SETUPDATEAMOUNT_PATH = "/setUpdateAmount";
	public static final String CUSTOMER = "Customer";
	public static final String CUSTOMERNAME = "CustomerName";
	public static final String DATE = "Date";
	public static final String CONTACT = "Contact";
	public static final String EMAIL = "Email";
	public static final String BALANCE = "Balance";
	public static final String BLOCKEDAMOUNT = "BlockedAmount";
	public static final String UNCHECKED = "unchecked";
	public static final String VALIDATION_ERROR = "validation error";
	public static final String GETCUSTOMERBYEMAILID_PATH = "/getcustomerbyemail";
	@Autowired
	private ICustomerService customerService;

	@SuppressWarnings(UNCHECKED)
	@GetMapping(value = CUSTOMERS_PATH)
	public ResponseEntity getAllCustomers() {
		try {
			return new ResponseEntity(customerService.getAllCustomers(), HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = GETCUSTOMER_PATH, method = RequestMethod.POST)
	public ResponseEntity getCustomerByUniqueId(@RequestParam("id") String id) {
		try {

			return new ResponseEntity(customerService.getCustomer(id), HttpStatus.ACCEPTED);
		} catch (ServiceException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}

	}

	@RequestMapping(method = RequestMethod.PATCH, value = CUSTOMERS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updatebalance(@RequestBody Customer customer) {
		String retval = null;
		HttpStatus status;
		try {
			retval = customerService.updateBalance(customer.getBalance(), customer.getUniqueId());
			status = HttpStatus.OK;
		} catch (ServiceException e) {
			retval = e.getMessage();
			status = HttpStatus.SERVICE_UNAVAILABLE;

		}
		return new ResponseEntity<String>(retval, status);
	}

	@RequestMapping(method = RequestMethod.POST, value = CUSTOMERS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		String retval = null;
		HttpStatus status;
		try {
			HashMap<String, String> errors = CustomerValidator.validate(customer);
			if (errors.isEmpty()) {
				retval = customerService.addCustomer(customer);
				status = HttpStatus.CREATED;
			} else {
				retval = VALIDATION_ERROR;
				status = HttpStatus.NOT_ACCEPTABLE;
			}
		} catch (ServiceException e) {
			retval = e.getMessage();
			status = HttpStatus.SERVICE_UNAVAILABLE;
		}
		return new ResponseEntity<String>(retval, status);

	}

	/**
	 * This method is used to block amount of customer
	 *
	 * @param customer
	 * @return string with message of completion
	 */
	@RequestMapping(method = RequestMethod.POST, value = SETBLOCKEDAMOUNT_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> blockAmount(@RequestBody Customer customer) {
		String retval = null;
		HttpStatus status;

		try {
			retval = customerService.blockAmount(customer.getBlockedAmount(), customer.getUniqueId());
			status = HttpStatus.ACCEPTED;
		} catch (ServiceException e) {
			retval = e.getMessage();
			status = HttpStatus.SERVICE_UNAVAILABLE;
		}
		return new ResponseEntity<String>(retval, status);

	}

	/**
	 * This method is used to adjust amount of customer
	 *
	 * @param customer
	 * @return string with message of completion
	 */
	@RequestMapping(method = RequestMethod.POST, value = SETUPDATEAMOUNT_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> adjustAmount(@RequestBody Customer customer) {
		String retval = null;
		HttpStatus status;
		try {
			retval = customerService.adjustAmount(customer.getBalance(), customer.getUniqueId());
			status = HttpStatus.ACCEPTED;
		} catch (ServiceException e) {
			retval = e.getMessage();
			status = HttpStatus.SERVICE_UNAVAILABLE;
		}
		return new ResponseEntity<String>(retval, status);

	}

	@RequestMapping(value = GETCUSTOMERBYEMAILID_PATH, method = RequestMethod.POST)
	public ResponseEntity getCustomerbyEmailId(@RequestBody Customer customer) {
		try {

			return new ResponseEntity(customerService.getCustomerByEmailId(customer.getEmail()), HttpStatus.ACCEPTED);
		} catch (ServiceException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}

	}

}
