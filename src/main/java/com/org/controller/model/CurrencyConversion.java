package com.org.controller.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyConversion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8704256242034678130L;
	String success;
//	@JsonSerialize(using = LocalTimeSerializer.class)
//	@JsonDeserialize(using = LocalTimeDeserializer.class)
//	Timestamp timestamp;
	String base;
	Date date;
    Map<String, BigDecimal> rates;
	
}
