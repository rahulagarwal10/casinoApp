package com.nagarro.java.freshertraining.roulettegame.service;

import javax.servlet.http.HttpSession;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.nagarro.java.freshertraining.roulettegame.exceptions.ServiceException;
import com.nagarro.java.freshertraining.roulettegame.model.BetFields;
import com.nagarro.java.freshertraining.roulettegame.model.Customer;

public interface IRouletteService {

	/**
	 * Method to calculate bet according to bet fields
	 *
	 * @param session
	 * @param fields
	 * @return
	 * @throws ServiceException
	 * @throws UnirestException
	 */
	long[] betCalculate(HttpSession session, BetFields fields) throws ServiceException;

	/**
	 * Method to get customer with its unique Identity
	 *
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	Customer getCurrentPlayer(String id) throws ServiceException;

}