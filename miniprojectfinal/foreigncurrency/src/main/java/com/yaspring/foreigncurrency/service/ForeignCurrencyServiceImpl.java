package com.yaspring.foreigncurrency.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
import com.fasterxml.jackson.databind.JsonNode;
import com.yaspring.foreigncurrency.Exception.ForeignCurrencyException;
import com.yaspring.foreigncurrency.httpclient.EcbClient;
import com.yaspring.foreigncurrency.model.PriceConversionRequest;

import retrofit2.Response;

@Service
public class ForeignCurrencyServiceImpl implements ForeignCurrencyService {
	
	@Autowired
	private EcbClient ecbClient;

	@Override
	public double getPriceInTargetCurrenct(PriceConversionRequest request) {
		Response<JsonNode> resp;
		try {
			resp = ecbClient.getExchangeRatess().execute();
			JsonNode exrate = resp.body();
			double rate = exrate.get("rates").get(String.valueOf(request.getTargetCurrency())).asDouble();	
			double convertedValue = rate * request.getPriceInEuro();
			return convertedValue;
		} catch (IOException e) {
			throw new ForeignCurrencyException("Exception occured while callin ECB service	", e);
		}
	}
	
	 

}
