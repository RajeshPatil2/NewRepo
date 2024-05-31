package com.application.excepiton;

public class RecordAlreadyPresentException extends RuntimeException {
	
	public RecordAlreadyPresentException(String msg) {
		super(msg);
	}

}
