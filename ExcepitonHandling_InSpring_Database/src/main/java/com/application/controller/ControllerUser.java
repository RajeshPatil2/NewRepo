package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.excepiton.RecordAlreadyPresentException;
import com.application.excepiton.UpdateNotPossibleExcepiton;
import com.application.excepiton.UserNotFoundExcepiton;
import com.application.model.User;
import com.application.service.UserServiceI;

@RestController
public class ControllerUser {

	@Autowired
	UserServiceI usi;

	@PostMapping("/insertUserData")
	public ResponseEntity<List<User>> insertUserData(@RequestBody User uData) {
		List<User> list = usi.postDataException(uData);
		ResponseEntity<List<User>> responseList = new ResponseEntity<List<User>>(list, HttpStatus.OK);
		return responseList;
	}
	
//	@PostMapping("/insertUserDataExcepiton")
//	public ResponseEntity<List<User>> insertUserDataExcepiton(@RequestBody User uData) {
//		List<User> list = usi.postDataException(uData);
//		ResponseEntity<List<User>> responseList = new ResponseEntity<List<User>>(list, HttpStatus.OK);
//		return responseList;
//	}

	@GetMapping("/getAllData")
	public ResponseEntity<List<User>> RetriveUserData() {
		List<User> list = usi.getData();
		ResponseEntity<List<User>> responseList = new ResponseEntity<List<User>>(list, HttpStatus.OK);
		return responseList;
	}

	@GetMapping("/getSingleData/{name}")
	public ResponseEntity<User> RetriveSingleData(@PathVariable String name, UserNotFoundExcepiton ue) {
		User singlUser = usi.getSingleData(name);
		ResponseEntity<User> responseList = new ResponseEntity<User>(singlUser, HttpStatus.OK);
		return responseList;
	}

//	@ExceptionHandler(UserNotFoundExcepiton.class)
//	public ResponseEntity<String> getNameException(UserNotFoundExcepiton ue) {
//		return new ResponseEntity<String>(ue.getMessage(), HttpStatus.BAD_REQUEST);
//	}

	@PutMapping("/updateSingleData/{name}")
	public ResponseEntity<User> UpdateSingleData(@PathVariable String name, @RequestBody User u) {
		User singlUser = usi.updateSingleData(name, u);
		ResponseEntity<User> responseList = new ResponseEntity<User>(singlUser, HttpStatus.OK);
		return responseList;
	}
	
	@ExceptionHandler(UpdateNotPossibleExcepiton.class)
	public ResponseEntity<String> updateNameExcepiton(UpdateNotPossibleExcepiton upe){
		return new ResponseEntity<String>(upe.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<String> insertTimeDuplicate(RecordAlreadyPresentException rp){
		return new ResponseEntity<String>(rp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	

}
