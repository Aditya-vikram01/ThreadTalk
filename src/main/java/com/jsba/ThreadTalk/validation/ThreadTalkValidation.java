package com.jsba.ThreadTalk.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ThreadTalkValidation {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<UserExceptionResponse> userExceptionHandler(ValidationFailedException execption) {

		UserExceptionResponse error = new UserExceptionResponse();
		error.setMessage(execption.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
