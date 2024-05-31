package com.application.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.excepiton.RecordAlreadyPresentException;
import com.application.excepiton.UpdateNotPossibleExcepiton;
import com.application.excepiton.UserNotFoundExcepiton;
import com.application.model.User;
import com.application.repository.UserRepository;
import com.application.service.UserServiceI;

@Service
public class ServiceImplUser implements UserServiceI {

	@Autowired
	UserRepository ur;

	@Override
	public List<User> postData(User uData) {
		ur.save(uData);
		return ur.findAll();
	}

	@Override
	public List<User> postDataException(User uData) {
		String name = uData.getName();
		if (ur.findById(name) == null) {
			ur.save(uData);
			return ur.findAll();
		} else {
			throw new RecordAlreadyPresentException("Duplicate primary key :" + name
					+ "\nRecord Already Presenet in Database for the primary key " + name);
		}
	}

	@Override
	public List<User> getData() {
		return ur.findAll();
	}

	@Override
	public User getSingleData(String name) {
		User findByName = ur.findByName(name);
		if (findByName == null) {
			throw new UserNotFoundExcepiton("No Record Found For Name:- " + name);
		} else {
			return findByName;
		}

	}

	@Override
	public User updateSingleData(String name, User u) {
		User checkUser = ur.findByName(name);
		if (checkUser == null) {
			throw new UpdateNotPossibleExcepiton("Name is not present to update " + name);
		} else {
			ur.save(u);
			return ur.findByName(name);
		}
	}

	
}
