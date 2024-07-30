package com.n2n.infotech.forex_microservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.n2n.infotech.forex_microservice.pojo.ExchangeRate;
import com.n2n.infotech.forex_microservice.service.ExchangeRateService;

@RestController
@RequestMapping("/fx")
public class ForeignExchangeController {
	@Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping
    public List<ExchangeRate> getExchangeRates(@RequestParam List<String> targetCurrencies) {
    	if (targetCurrencies == null || targetCurrencies.isEmpty()) {
            targetCurrencies = Arrays.asList("EUR", "GBP", "JPY", "CZK"); // Default currencies
        }
        return exchangeRateService.getExchangeRates(targetCurrencies);
    }

    @GetMapping("/{targetCurrency}")
    public List<ExchangeRate> getLatestExchangeRates(@PathVariable String targetCurrency) {
        return exchangeRateService.getLatestExchangeRates(targetCurrency);
    }
}
