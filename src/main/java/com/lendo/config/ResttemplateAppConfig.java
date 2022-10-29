package com.lendo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.var;

@Configuration
public class ResttemplateAppConfig {

	@Bean
	public RestTemplate restTemplate() {
	 
		var factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);
		return new RestTemplate(factory);
	}
	
	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}
	

}
