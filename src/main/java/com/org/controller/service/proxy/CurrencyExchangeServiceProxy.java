package com.org.controller.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.controller.model.CurrencyConversion;

@FeignClient(name="currencyExchangeServiceProxy", url = "http://data.fixer.io/")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("api/latest")
	public CurrencyConversion retrieveExchangeValue(@RequestParam(name = "access_key") String access_key,@RequestParam(name = "symbols") String symbols,@RequestParam(name = "format") String format);
	
}
