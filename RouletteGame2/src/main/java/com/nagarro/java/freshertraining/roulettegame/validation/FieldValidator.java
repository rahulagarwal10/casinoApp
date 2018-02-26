package com.nagarro.java.freshertraining.roulettegame.validation;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.nagarro.java.freshertraining.roulettegame.model.BetFields;

/**
 * Class to validate Bet Fileds
 *
 * @author rahulagarwal
 *
 */
public class FieldValidator {

	// Constants
	public static final String AMOUNT = "Amount";
	public static final String AMOUNT_ERROR = "Should be multiple of 500";
	public static final String AMOUNT_VALUE = "Amount Value";
	public static final String AMOUNT_VALUE_ERROR = "Should be greater than zero";
	public static final String BALANCE_ERROR = "Insufficient Balance";
	public static final String BALANCE = "balance";

	/**
	 * Method to validate all fields of Betfileds
	 *
	 * @param fields
	 * @param balance
	 * @return Hashmap of Errors
	 */
	public static HashMap<String, String> validate(BetFields fields, Object balance) {
		HashMap<String, String> errors = new LinkedHashMap<String, String>();

		if (fields.getEven() % 500 != 0 || fields.getFirst12() % 500 != 0 || fields.getFirst18() % 500 != 0
				|| fields.getOdd() % 500 != 0 || fields.getSecond12() % 500 != 0 || fields.getSecond18() % 500 != 0
				|| fields.getThird12() % 500 != 0 || fields.getZero() % 500 != 0) {
			errors.put(AMOUNT, AMOUNT_ERROR);
		}

		if (fields.getEven() < 0 || fields.getFirst12() < 0 || fields.getFirst18() < 0 || fields.getOdd() < 0
				|| fields.getSecond12() < 0 || fields.getSecond18() < 0 || fields.getThird12() < 0
				|| fields.getZero() < 0) {
			errors.put(AMOUNT_VALUE, AMOUNT_VALUE_ERROR);

		}
		if (fields.getEven() + fields.getFirst12() + fields.getFirst18() + fields.getOdd() + fields.getSecond12()
				+ fields.getSecond18() + fields.getThird12() + fields.getZero() > Long.parseLong(balance.toString())) {
			errors.put(BALANCE, BALANCE_ERROR);
		}

		return errors;
	}

}
