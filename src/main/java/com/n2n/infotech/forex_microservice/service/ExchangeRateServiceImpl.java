package com.n2n.infotech.forex_microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.n2n.infotech.forex_microservice.dto.ExchangeRateApiResponse;
import com.n2n.infotech.forex_microservice.pojo.ExchangeRate;
import com.n2n.infotech.forex_microservice.repository.ExchangeRateRepository;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	@Autowired
	private ExchangeRateRepository exchangeRateRepository;

	@Autowired
	private RestTemplate restTemplate;

	private static final String API_URL = "https://api.frankfurter.app/latest";

	@Override
	public List<ExchangeRate> getExchangeRates(List<String> targetCurrencies) {
		String url = API_URL + "?from=USD&to=" + String.join(",", targetCurrencies);
		ExchangeRateApiResponse apiResponse = restTemplate.getForObject(url, ExchangeRateApiResponse.class);

		for (String targetCurrency : targetCurrencies) {
			if (!exchangeRateRepository.existsByDateAndBaseCurrencyAndTargetCurrency(apiResponse.getDate(), "USD",
					targetCurrency)) {
				ExchangeRate exchangeRate = new ExchangeRate();
				exchangeRate.setDate(apiResponse.getDate());
				exchangeRate.setBaseCurrency("USD");
				exchangeRate.setTargetCurrency(targetCurrency);
				exchangeRate.setExchangeRate(apiResponse.getRates().get(targetCurrency));
				exchangeRateRepository.save(exchangeRate);
			}
		}
		return exchangeRateRepository.findByBaseCurrencyAndTargetCurrency("USD", "EUR");
	}

	@Override
	public List<ExchangeRate> getLatestExchangeRates(String targetCurrency) {
		return exchangeRateRepository.findTop3ByBaseCurrencyAndTargetCurrencyOrderByDateDesc("USD", targetCurrency);
	}

}
