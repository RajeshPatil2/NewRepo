package com.application.dto;

import java.util.Date;

public class ResponseDto {

	private String message;
	private Date timeStamp;

	public ResponseDto() {

	}

	public ResponseDto(String message, Date timeStamp) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
