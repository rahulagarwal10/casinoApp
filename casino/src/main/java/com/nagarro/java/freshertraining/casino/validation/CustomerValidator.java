package com.nagarro.java.freshertraining.casino.validation;

import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.java.freshertraining.casino.model.Customer;

/**
 * Class to validate customer
 *
 * @author rahulagarwal
 *
 */
public class CustomerValidator {
	public static final String CUSTOMER_NAME = "CustomerName";
	public static final String CUSTOMER_ERROR = "Customer name is Not Valid";
	public static final String EMAIL_REGEX = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	public static final String EMAIL_ERROR = "Email is not Valid";
	public static final String EMAIL_NULL = "Email cannot be null";
	public static final String CONTACT_ERROR = "Contact is not Valid";
	public static final String DOB = "Date Of Birth";
	public static final String DOB_ERROR = "Must be Above 18 years and valid";
	public static final String EMAIL = "Email";
	public static final String CONTACT = "Contact";

	/**
	 * Method which validate all the fields of customer
	 *
	 * @param customer
	 * @return HashMap Of Errors
	 */
	public static HashMap<String, String> validate(Customer customer) {
		HashMap<String, String> errors = new LinkedHashMap<String, String>();

		if (customer.getCustomerName().equals(null) || customer.getCustomerName().equals("")
				|| !customer.getCustomerName().chars().allMatch(Character::isLetter)) {
			errors.put(CUSTOMER_NAME, CUSTOMER_ERROR);
		}
		if (customer.getEmail() != null) {
			String regex = EMAIL_REGEX;
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(customer.getEmail());
			if (!matcher.matches()) {
				errors.put(EMAIL, EMAIL_ERROR);
			}
		} else {
			errors.put(EMAIL, EMAIL_NULL);
		}

		if (customer.getContact().equals(null) || customer.getContact().toString().length() != 10
				|| !customer.getContact().toString().chars().allMatch(Character::isDigit)) {
			errors.put(CONTACT, CONTACT_ERROR);
		}

		if (customer.getDate().equals(null) || customer.getDate().toString().equals("")) {
			errors.put(DOB, DOB_ERROR);
		}

		return errors;
	}

	public void checkdate(Customer customer) {

		Date date = customer.getDate();

	}
}
