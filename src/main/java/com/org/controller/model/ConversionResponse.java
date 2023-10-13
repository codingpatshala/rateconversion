package com.org.controller.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8861134288947065388L;
	
	private  BigDecimal quantity;
	
	private String to;
	
	private BigDecimal currentrate;
	
	private String status;
	
}
