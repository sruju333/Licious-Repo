package com.licious.practice.deptemploy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping
	ResponseEntity<String> main(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "EmpDept Main Page");
		return new ResponseEntity<>("This is the Main Page!", headers, HttpStatus.OK);
	}
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hello, Welcome to Dept-Employ SpringBoot App!";
	}
	
	
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/")
	public String index() {
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");
		
		return "Howdy! Check out the logs to see the output...";
		
	}

}
