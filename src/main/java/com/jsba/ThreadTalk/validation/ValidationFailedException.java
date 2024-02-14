package com.jsba.ThreadTalk.validation;

@SuppressWarnings("serial")
public class ValidationFailedException extends RuntimeException  {

	public ValidationFailedException(String message) {
		super(message);

	}

}
