package com.yaspring.foreigncurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaspring.foreigncurrency.model.PriceConversionRequest;
import com.yaspring.foreigncurrency.service.ForeignCurrencyService;

@RestController
@RequestMapping("/api/v1")
public class ForeignCurrencyController {
	
	@Autowired
	private ForeignCurrencyService foreignCurrencyService;
	
	@PostMapping("/price")
	public double getPrice(@RequestBody PriceConversionRequest request){
		return foreignCurrencyService.getPriceInTargetCurrenct(request);
	}
	
}
