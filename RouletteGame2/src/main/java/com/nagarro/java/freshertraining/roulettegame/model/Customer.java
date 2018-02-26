package com.nagarro.java.freshertraining.roulettegame.model;

import java.sql.Date;

public class Customer {

	private String uniqueId;
	private String customerName;
	private Date date;
	private String contact;
	private String email;
	private long balance;
	private long blockedAmount;

	public long getBlockedAmount() {
		return blockedAmount;
	}

	public void setBlockedAmount(long blockedAmount) {
		this.blockedAmount = blockedAmount;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String id) {
		this.uniqueId = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
