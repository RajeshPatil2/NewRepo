package com.application.excepiton;

public class UserNotFoundExcepiton  extends RuntimeException{

	public UserNotFoundExcepiton(String msg) {
		super(msg);
	}
}
