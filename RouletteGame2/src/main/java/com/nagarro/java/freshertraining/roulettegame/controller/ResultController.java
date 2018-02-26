package com.nagarro.java.freshertraining.roulettegame.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.nagarro.java.freshertraining.roulettegame.exceptions.ServiceException;
import com.nagarro.java.freshertraining.roulettegame.model.BetFields;
import com.nagarro.java.freshertraining.roulettegame.service.IRouletteService;
import com.nagarro.java.freshertraining.roulettegame.validation.FieldValidator;

/**
 * Class to control the result of the game
 *
 * @author rahulagarwal
 *
 */
@RestController
public class ResultController {

	// Constants
	public static final String CALCULATE = "/calculate";
	public static final String CBALANCE = "cbalance";

	@Autowired
	private IRouletteService rouletteService;

	/**
	 * Method which Calculates bet/final amount according to bet fields
	 *
	 * @param fields
	 * @param session
	 * @return long array of result
	 * @throws UnirestException
	 * @throws ServiceException
	 */
	@RequestMapping(method = RequestMethod.POST, value = CALCULATE)
	public long[] calculateBet(@RequestBody BetFields fields, HttpSession session)
			throws ServiceException, UnirestException {

		try {
			HashMap<String, String> errors = FieldValidator.validate(fields, session.getAttribute(CBALANCE));
			if (errors.isEmpty()) {
				return rouletteService.betCalculate(session, fields);
			} else {
				return null;
			}

		} catch (Exception e) {
			return null;
		}

	}

}
