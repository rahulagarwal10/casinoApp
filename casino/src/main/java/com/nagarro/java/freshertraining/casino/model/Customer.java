package com.nagarro.java.freshertraining.casino.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@NotNull
	@Column(name = "UniqueId")
	private String uniqueId;

	@NotNull
	@Column(name = "CustomerName")
	private String customerName;

	@NotNull
	@Column(name = "Date")
	private Date date;

	@NotNull
	@Column(name = "Contact")
	private String contact;

	@NotNull
	@Email
	@Column(name = "Email")
	private String email;

	@NotNull
	@Column(name = "Balance")
	private long balance;

	@NotNull
	@Column(name = "BlockedAmount")
	private long blockedAmount;

	@Column(name = "IdentityProof")
	private String identityProof;

	public String getIdentityProof() {
		return identityProof;
	}

	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

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
