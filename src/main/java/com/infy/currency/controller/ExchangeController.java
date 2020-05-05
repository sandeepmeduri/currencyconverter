package com.infy.currency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infy.currency.entity.Exchange;
import com.infy.currency.repository.ExchangeRepository;

@RestController
public class ExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeRepository repository;

	@GetMapping("/api/currency-exchange/from/{from}/to/{to}")
	public Exchange fetchExchangeValue(@PathVariable String from, @PathVariable String to) {

		Exchange exchangeValue = repository.findByFromAndTo(from, to);

		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

		return exchangeValue;
	}
	
	@GetMapping("/api/currency-exchange")
	public List<Exchange> fetchAllExchangeValue() {

		List<Exchange> exchangeValue = repository.findAll();

		exchangeValue.stream().forEach(p->{
			p.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		});;

		return exchangeValue;
	}
	
}
