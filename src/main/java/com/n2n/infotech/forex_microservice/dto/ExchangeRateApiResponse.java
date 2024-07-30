package com.n2n.infotech.forex_microservice.dto;

import java.util.Date;
import java.util.Map;

public class ExchangeRateApiResponse {
	private double amount;
	private String base;
	private Date date;
	private Map<String, Double> rates;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	public ExchangeRateApiResponse() {
		super();
	}

}
