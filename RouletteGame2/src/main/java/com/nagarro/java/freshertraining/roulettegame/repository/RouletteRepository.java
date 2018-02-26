package com.nagarro.java.freshertraining.roulettegame.repository;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nagarro.java.freshertraining.roulettegame.exceptions.RepositoryException;
import com.nagarro.java.freshertraining.roulettegame.model.Customer;

@Repository
public class RouletteRepository implements IRouletteRepository {

	// Constants
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String BLOCKED_AMOUNT = "blockedAmount";
	public static final String UNIQUE_ID = "uniqueId";
	public static final String UPDATEAMOUNT_URL = "http://localhost:8080/setUpdateAmount";
	public static final String BALANCE = "balance";
	public static final String GETCUSTOMER_URL = "http://localhost:8080/getcustomer";
	public static final String REPOSITORY_ERROR = "Repository Error";
	public static final String BLOCKAMOUNT_URL = "http://localhost:8080/setBlockedAmount";
	public static final String ACCEPT = "accept";
	public static final String ID = "id";

	@Override
	public Customer getCurrentPlayer(String id) throws RepositoryException {

		String url = GETCUSTOMER_URL;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add(ID, id);
		HttpEntity requestEntity = new HttpEntity(form, headers);
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = null;

		try {
			customer = restTemplate.postForObject(url, requestEntity, Customer.class);
		} catch (Exception e) {
			throw new RepositoryException(REPOSITORY_ERROR);
		}
		return customer;
	}

	@Override
	public boolean blockAmount(long blocked_amount, HttpSession session) throws RepositoryException {
		boolean retVal = false;
		try {
			JSONObject customer = new JSONObject();
			customer.put(BLOCKED_AMOUNT, blocked_amount);
			customer.put(UNIQUE_ID, session.getAttribute(ID));
			Unirest.post(BLOCKAMOUNT_URL).header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.header(ACCEPT, MediaType.APPLICATION_JSON_VALUE).body(customer).asString();

			retVal = true;

		} catch (UnirestException e) {
			throw new RepositoryException(REPOSITORY_ERROR);

		}
		return retVal;
	}

	@Override
	public void adjustAmount(long game_amount, HttpSession session) throws RepositoryException {
		try {
			JSONObject customer = new JSONObject();

			customer.put(BALANCE, game_amount);
			customer.put(UNIQUE_ID, session.getAttribute(ID));

			Unirest.post(UPDATEAMOUNT_URL).header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.header(ACCEPT, MediaType.APPLICATION_JSON_VALUE).body(customer).asString();

		} catch (UnirestException e) {
			throw new RepositoryException(REPOSITORY_ERROR);
		}
	}

}
