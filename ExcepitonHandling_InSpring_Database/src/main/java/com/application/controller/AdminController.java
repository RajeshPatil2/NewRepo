package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.application.excepiton.UserNotFoundExcepiton;
import com.application.model.User;
import com.application.service.UserServiceI;

@RestControllerAdvice
public class AdminController {
	
	@Autowired
	UserServiceI usi;
	
	@GetMapping("/getSingleData/{name}")
	public ResponseEntity<User> RetriveSingleData(@PathVariable String name, UserNotFoundExcepiton ue) {
		User singlUser = usi.getSingleData(name);
		ResponseEntity<User> responseList = new ResponseEntity<User>(HttpStatus.OK);
		return responseList;
	}
	
	@ExceptionHandler(UserNotFoundExcepiton.class)
	public ResponseEntity<String> getNameException(UserNotFoundExcepiton ue) {
		return new ResponseEntity<String>(ue.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
