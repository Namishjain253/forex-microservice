package com.n2n.infotech.forex_microservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import com.n2n.infotech.forex_microservice.service.ExchangeRateService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ForeignExchangeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ExchangeRateService exchangeRateService;

	@Test
	public void testGetExchangeRates() throws Exception {
		mockMvc.perform(get("/fx").param("targetCurrencies", "EUR,GBP,JPY,CZK").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testGetLatestExchangeRates() throws Exception {
		mockMvc.perform(get("/fx/EUR").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
}
