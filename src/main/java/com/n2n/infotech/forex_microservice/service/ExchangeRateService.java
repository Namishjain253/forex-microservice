package com.n2n.infotech.forex_microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.n2n.infotech.forex_microservice.pojo.ExchangeRate;

@Service
public interface ExchangeRateService {
	public List<ExchangeRate> getExchangeRates(List<String> targetCurrencies);
	public List<ExchangeRate> getLatestExchangeRates(String targetCurrency);
}
