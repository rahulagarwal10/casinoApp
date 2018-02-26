package com.nagarro.java.freshertraining.roulettegame.repository;

import javax.servlet.http.HttpSession;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.nagarro.java.freshertraining.roulettegame.exceptions.RepositoryException;
import com.nagarro.java.freshertraining.roulettegame.model.Customer;

public interface IRouletteRepository {

	/**
	 * Method to get customer based on its unique Identity
	 *
	 * @param id
	 * @return Customer
	 * @throws RepositoryException
	 */
	Customer getCurrentPlayer(String id) throws RepositoryException;

	/**
	 * Method to block amount of customer
	 *
	 * @param blocked_amount
	 * @param session
	 * @throws RepositoryException
	 * @throws UnirestException
	 */
	boolean blockAmount(long blocked_amount, HttpSession session) throws RepositoryException;

	/**
	 * Method to adjust amount of customer
	 *
	 * @param game_amount
	 * @param session
	 * @throws RepositoryException
	 */
	void adjustAmount(long game_amount, HttpSession session) throws RepositoryException;

}