package com.dnyanesh.sleuthserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello")
public class SleuthServerController {

	private static Logger LOGGER = LoggerFactory.getLogger(SleuthServerController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${server.port}")
	private String port;

	@GetMapping("/server")
	public String sayHello() {
		LOGGER.info("Before returning value from Server :: Server");
		String response = restTemplate.getForObject("http://localhost:7777/api", String.class);
		LOGGER.info("After returning value from Server :: Server");
		return response;
		
		//return " :: Server Port: "+port;
	}

}
