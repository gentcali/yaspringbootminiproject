package com.yaspring.foreigncurrency.Exception;

public class ForeignCurrencyException extends RuntimeException {

	private static final long serialVersionUID = -3697364338016828050L;
	
	public ForeignCurrencyException(String message, Exception e) {
		super(message, e);
	}
}
