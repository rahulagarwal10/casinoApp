package com.nagarro.java.freshertraining.roulettegame.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.java.freshertraining.roulettegame.exceptions.RepositoryException;
import com.nagarro.java.freshertraining.roulettegame.exceptions.ServiceException;
import com.nagarro.java.freshertraining.roulettegame.model.BetFields;
import com.nagarro.java.freshertraining.roulettegame.model.Customer;
import com.nagarro.java.freshertraining.roulettegame.repository.IRouletteRepository;

/**
 * Class to give all services related to game
 *
 * @author rahulagarwal
 *
 */
@Service("IRouletteService")
public class RouletteService implements IRouletteService {

	@Autowired
	private RandomNumberGenerator randomNumberGenerator;

	@Autowired
	private IRouletteRepository rouletteRepository;

	@Override
	public long[] betCalculate(HttpSession session, BetFields fields) throws ServiceException {

		long result[] = new long[3];
		long win_amount = 0, loose_amount = 0, game_amount = 0;
		long blocked_amount = fields.getFirst12() + fields.getSecond12() + fields.getThird12() + fields.getFirst18()
				+ fields.getSecond18() + fields.getEven() + fields.getOdd() + fields.getZero();
		boolean isBlocked;
		try {
			isBlocked = rouletteRepository.blockAmount(blocked_amount, session);
		} catch (RepositoryException e) {
			throw new ServiceException();
		}

		if (isBlocked) {

			long randomNumber = randomNumberGenerator.generate();

			if (fields.getFirst12() > 0) {
				if (randomNumber > 0 && randomNumber <= 12) {
					win_amount += fields.getFirst12() * 1.5;
				} else {
					loose_amount += fields.getFirst12();
				}
			}
			if (fields.getSecond12() > 0) {
				if (randomNumber > 12 && randomNumber <= 24) {
					win_amount += fields.getSecond12() * 1.5;
				} else {
					loose_amount += fields.getSecond12();
				}
			}
			if (fields.getThird12() > 0) {
				if (randomNumber > 24 && randomNumber <= 36) {
					win_amount += fields.getThird12() * 1.5;
				} else {
					loose_amount += fields.getThird12();
				}
			}
			if (fields.getZero() > 0) {
				if (randomNumber == 0) {
					win_amount += fields.getZero() * 10;
				} else {
					loose_amount += fields.getZero();
				}
			}
			if (fields.getFirst18() > 0) {
				if (randomNumber > 0 && randomNumber <= 18) {
					win_amount += fields.getFirst18() * 1.25;
				} else {
					loose_amount += fields.getFirst18();
				}
			}
			if (fields.getSecond18() > 0) {
				if (randomNumber > 18 && randomNumber <= 36) {
					win_amount += fields.getSecond18() * 1.25;
				} else {
					loose_amount += fields.getSecond18();
				}
			}
			if (fields.getEven() > 0) {
				if (randomNumber % 2 == 0) {
					win_amount += fields.getEven() * 1.25;
				} else {
					loose_amount += fields.getEven();
				}
			}
			if (fields.getOdd() > 0) {
				if (randomNumber % 2 == 1) {
					win_amount += fields.getOdd() * 1.25;
				} else {
					loose_amount += fields.getOdd();
				}
			}

			game_amount = win_amount - loose_amount;
			result[0] = randomNumber;
			result[1] = game_amount;
			result[2] = blocked_amount;

			try {
				rouletteRepository.adjustAmount(game_amount, session);
			} catch (RepositoryException e) {
				throw new ServiceException();
			}

			return result;
		} else {
			return null;
		}

	}

	@Override
	public Customer getCurrentPlayer(String id) throws ServiceException {

		try {
			return rouletteRepository.getCurrentPlayer(id);
		} catch (RepositoryException e) {
			throw new ServiceException();
		}
	}

}
