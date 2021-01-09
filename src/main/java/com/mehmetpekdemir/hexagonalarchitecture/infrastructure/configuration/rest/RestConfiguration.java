package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.configuration.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Configuration
public class RestConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}