package com.infy.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.currency.entity.Exchange;

public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
	Exchange findByFromAndTo(String from, String to);
}
