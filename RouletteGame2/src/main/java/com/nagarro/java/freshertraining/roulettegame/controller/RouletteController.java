package com.nagarro.java.freshertraining.roulettegame.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.nagarro.java.freshertraining.roulettegame.exceptions.ServiceException;
import com.nagarro.java.freshertraining.roulettegame.model.Customer;
import com.nagarro.java.freshertraining.roulettegame.service.IRouletteService;

/**
 * Class to control all the operations of game
 *
 * @author rahulagarwal
 *
 */
@Controller
@SessionAttributes("id")

public class RouletteController {

	// Constants
	public static final String LOGIN = "login";
	public static final String GAME = "game";
	public static final String ERROR = "error";
	public static final String INVALIDKEY = "Invalid Key";
	public static final String LOGERROR = "logerror";
	public static final String ENTERKEY = "Please Enter Key";
	public static final String CURRENTPLAYER = "/currentPlayer";
	public static final String EXIT = "/exit";
	public static final String CNAME = "cname";
	public static final String CBALANCE = "cbalance";
	public static final String REDIRECT = "redirect:/";
	public static final String ID = "id";

	@Autowired
	private IRouletteService rouletteService;

	/**
	 * This method return login page to user
	 *
	 * @param session
	 * @param model
	 * @return login.jsp page
	 */
	@RequestMapping("/")
	public String userLogin(HttpSession session, Model model) {
		return LOGIN;

	}

	/**
	 * This method allow user to exit from game and take back to login page
	 *
	 * @param session
	 * @param status
	 * @param model
	 * @return login.jsp
	 */
	@RequestMapping(value = EXIT)
	public String exit(HttpSession session, SessionStatus status, Model model) {
		session.removeAttribute(ID);
		status.setComplete();
		session.getAttribute(ID);
		model.addAttribute(CNAME, null);
		model.addAttribute(CBALANCE, null);
		model.addAttribute(ERROR, null);
		session.invalidate();
		return REDIRECT;
	}

	/**
	 * This method get the game page authenticated by the unique key
	 *
	 * @param session
	 * @param model
	 * @param id
	 * @return game.jsp page
	 */
	@RequestMapping(value = CURRENTPLAYER)
	public String getCurrentPlayer(HttpSession session, Model model, @RequestParam("id") String id) {

		String viewName = LOGIN;
		try {
			if (id == null || id == "") {
				model.addAttribute(LOGERROR, ENTERKEY);
				viewName = LOGIN;

			} else {
				Customer customer = rouletteService.getCurrentPlayer(id);

				if (customer != null) {

					session.setAttribute(ID, customer.getUniqueId());
					session.setAttribute(CBALANCE, customer.getBalance());
					model.addAttribute(CNAME, customer.getCustomerName());
					model.addAttribute(CBALANCE, customer.getBalance());
					viewName = GAME;

				} else {
					model.addAttribute(ERROR, INVALIDKEY);
					viewName = LOGIN;
				}
			}
		} catch (ServiceException e) {
			viewName = ERROR;
		}
		return viewName;
	}

}
