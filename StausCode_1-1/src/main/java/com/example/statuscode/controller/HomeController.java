package com.example.statuscode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	/*
	 * @GetMapping("/getMap") public String getMethodName() { return
	 * "welcome to page"; }
	 */

	@GetMapping("/getResponse")
	public ResponseEntity<String> getUser()
	{
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Welcome To Status Code... .BAD_GATEWAY", HttpStatus.BAD_GATEWAY);
		return responseEntity;
				
	}
	
}
