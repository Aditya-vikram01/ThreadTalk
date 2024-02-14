package com.jsba.ThreadTalk.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

	private String commentFrom;
	private String commentTo;
	private String message;

}
