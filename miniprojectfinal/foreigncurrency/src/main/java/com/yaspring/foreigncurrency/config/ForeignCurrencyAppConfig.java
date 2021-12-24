package com.yaspring.foreigncurrency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yaspring.foreigncurrency.httpclient.EcbClient;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class ForeignCurrencyAppConfig {

	@Bean
	public EcbClient ecbClient() {
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("https://api.exchangerate.host")
			    .addConverterFactory(JacksonConverterFactory.create())
			    .build();
		return retrofit.create(EcbClient.class);
	} 
}
