package com.jsba.ThreadTalk.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserExceptionResponse {

	private int status;
	private String message;
	private long timestamp;

}
