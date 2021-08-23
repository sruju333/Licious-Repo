package com.licious.practice.deptemploy.controller;

import lombok.AllArgsConstructor;


public class CustomException extends Exception {
	
	public CustomException() {
		super("Page not Available");
	}

}
