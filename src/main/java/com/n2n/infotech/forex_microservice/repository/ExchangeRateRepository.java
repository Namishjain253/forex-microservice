package com.n2n.infotech.forex_microservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.n2n.infotech.forex_microservice.pojo.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    List<ExchangeRate> findByBaseCurrencyAndTargetCurrency(String baseCurrency, String targetCurrency);
    List<ExchangeRate> findTop3ByBaseCurrencyAndTargetCurrencyOrderByDateDesc(String baseCurrency, String targetCurrency);
    boolean existsByDateAndBaseCurrencyAndTargetCurrency(Date date, String baseCurrency, String targetCurrency);
}