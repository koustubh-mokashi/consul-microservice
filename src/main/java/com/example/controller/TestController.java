package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	@Autowired
	@Qualifier("client")
	private RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public String getMapping() {
		return restTemplate.getForObject("http://sample-service2/testing", String.class);
	}

	@RequestMapping(path = "/health", method = RequestMethod.GET, produces = "application/json")
	public String health() {
		return "OK";
	}

}
