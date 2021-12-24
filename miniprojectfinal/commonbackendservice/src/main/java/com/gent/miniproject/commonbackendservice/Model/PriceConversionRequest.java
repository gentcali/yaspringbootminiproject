package com.gent.miniproject.commonbackendservice.Model;

public class PriceConversionRequest {
	
	private double priceInEuro;
	
	private String targetCurrency;

	public double getPriceInEuro() {
		return priceInEuro;
	}

	public void setPriceInEuro(double priceInEuro) {
		this.priceInEuro = priceInEuro;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public PriceConversionRequest(double priceInEuro, String targetCurrency) {
		super();
		this.priceInEuro = priceInEuro;
		this.targetCurrency = targetCurrency;
	}

}
