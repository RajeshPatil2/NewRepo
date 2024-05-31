package com.application.service;

import java.util.List;

import com.application.dto.ResponseDto;
import com.application.model.User;

public interface UserServiceI {

	List<User> postData(User uData);

	List<User> getData();

	User getSingleData(String name);

	User updateSingleData(String name, User u);

	List<User> postDataException(User uData);

}
