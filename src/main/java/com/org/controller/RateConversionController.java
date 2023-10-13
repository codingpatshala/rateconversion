package com.org.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.controller.model.ConversionResponse;
import com.org.controller.service.CurrencyExchangeService;

//https://www.glassdoor.com/Interview/Kindred-Group-Interview-Questions-E1491697_P3.htm
//https://medium.com/javarevisited/microservices-with-spring-boot-and-java-part-3-example-2-creating-currency-conversion-55c008814201
//http://localhost:8100/currency-converter/from/EUR/to/INR/quantity/10000
//https://girishgodage.in/blog/Creating-microservices-with-spring-boot-part-3-currency-conversion-microservice
//https://www.oanda.com/currency-converter/en/?from=INR&to=USD&amount=1000
//https://fixer.io/
//https://www.appsdeveloperblog.com/feign-client-to-call-another-microservice/
//http://localhost:8080/api/v1/convert?from=EUR&to=USD&quantity=1000

@RestController
@RequestMapping("/api/v1")
public class RateConversionController {
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/convert")
	public ResponseEntity<ConversionResponse> getConversion(@RequestParam String from, @RequestParam String to,
			@RequestParam BigDecimal quantity) {
		
		
		ConversionResponse respnse = currencyExchangeService.getConversion(from,to,quantity);

		return new ResponseEntity<ConversionResponse>(respnse, HttpStatus.OK);
	}
	
	
}
