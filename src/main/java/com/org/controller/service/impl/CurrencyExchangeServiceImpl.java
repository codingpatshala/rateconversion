package com.org.controller.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.controller.model.ConversionResponse;
import com.org.controller.model.CurrencyConversion;
import com.org.controller.service.CurrencyExchangeService;
import com.org.controller.service.proxy.CurrencyExchangeServiceProxy;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	
	
	public ConversionResponse getConversion(String from,String to,BigDecimal quantity) {
		
		String access_key = "03fc26dfa396fda2e2ca712075b6165f";
		String symbols = "USD,AUD,CAD,PLN,MXN";
		String format = "1";
		CurrencyConversion conversion = null;
		ConversionResponse response = new ConversionResponse();
		if(from.equalsIgnoreCase("EUR")) {
			conversion = currencyExchangeServiceProxy.retrieveExchangeValue(access_key, symbols, format);
		}else {
			throw new RuntimeException("Currently we support only From EUR conversion .");
		}
		
		if(conversion != null && conversion.getRates().get(to)!=null) {
			
			BigDecimal rate_to = conversion.getRates().get(to);

			
			BigDecimal converted_quantity = quantity.divide(rate_to,2, RoundingMode.HALF_UP);

			response.setCurrentrate(rate_to);
			response.setTo(to);
			response.setQuantity(converted_quantity);
			response.setStatus("Success");
			
			
		}else {
			throw new RuntimeException("we Don't support conversion to "+to);
		}
		
	//	response.setStatus(conversion.getSuccess());
		return response;
	}


	
}
