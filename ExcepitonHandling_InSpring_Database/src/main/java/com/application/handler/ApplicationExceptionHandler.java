package com.application.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.application.dto.ResponseDto;
import com.application.excepiton.UserNotFoundExcepiton;

@RestControllerAdvice /* Globally Exception Handler this class */
public class ApplicationExceptionHandler {

	@ExceptionHandler(UserNotFoundExcepiton.class)
	public ResponseEntity<String> getNameException(UserNotFoundExcepiton ue) {
		return new ResponseEntity<String>(ue.getMessage(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<ResponseDto> handlerUserNotFound(UserNotFoundExcepiton ue) {
		ResponseDto responseDto = new ResponseDto(ue.getMessage(), new Date());
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.NOT_FOUND);
	}
}
