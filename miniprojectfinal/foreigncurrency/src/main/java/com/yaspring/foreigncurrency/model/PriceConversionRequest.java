package com.yaspring.foreigncurrency.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceConversionRequest {
	
	@JsonProperty
	private double priceInEuro;
	
	@JsonProperty
	private Currency targetCurrency;

	public double getPriceInEuro() {
		return priceInEuro;
	}

	public void setPriceInEuro(double priceInEuro) {
		this.priceInEuro = priceInEuro;
	}

	public Currency getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(Currency targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	
	

}
