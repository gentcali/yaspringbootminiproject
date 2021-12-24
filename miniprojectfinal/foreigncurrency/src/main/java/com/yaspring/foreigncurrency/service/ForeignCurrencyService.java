package com.yaspring.foreigncurrency.service;

import com.yaspring.foreigncurrency.model.PriceConversionRequest;

public interface ForeignCurrencyService {
	public double getPriceInTargetCurrenct(PriceConversionRequest request);
}
