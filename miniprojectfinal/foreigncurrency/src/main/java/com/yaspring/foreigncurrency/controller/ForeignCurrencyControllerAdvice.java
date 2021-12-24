package com.yaspring.foreigncurrency.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yaspring.foreigncurrency.model.ErrorResponse;

@ControllerAdvice
public class ForeignCurrencyControllerAdvice {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ErrorResponse handleException(Exception e){
		return new ErrorResponse("E002", e.getMessage());
	}
}
