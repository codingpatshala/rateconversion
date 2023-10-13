package com.org.controller.service;

import java.math.BigDecimal;

import com.org.controller.model.ConversionResponse;

public interface CurrencyExchangeService {

	public ConversionResponse getConversion(String from,String to,BigDecimal quantity) ;
}
