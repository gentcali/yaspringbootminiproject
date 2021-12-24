package com.yaspring.foreigncurrency.httpclient;

import com.fasterxml.jackson.databind.JsonNode;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EcbClient {

	@GET("/latest?base=EUR")
	Call<JsonNode> getExchangeRatess();
}
