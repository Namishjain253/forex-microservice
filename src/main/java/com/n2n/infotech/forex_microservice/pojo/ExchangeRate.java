package com.n2n.infotech.forex_microservice.pojo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class ExchangeRate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String baseCurrency;

	private String targetCurrency;

	private Double exchangeRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public ExchangeRate(Long id, Date date, String baseCurrency, String targetCurrency, Double exchangeRate) {
		super();
		this.id = id;
		this.date = date;
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
		this.exchangeRate = exchangeRate;
	}

	public ExchangeRate() {
		super();
	}

	@Override
	public String toString() {
		return "ExchangeRate [id=" + id + ", date=" + date + ", baseCurrency=" + baseCurrency + ", targetCurrency="
				+ targetCurrency + ", exchangeRate=" + exchangeRate + "]";
	}

}
