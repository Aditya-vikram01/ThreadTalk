package com.jsba.ThreadTalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsba.ThreadTalk.dto.Comment;
import com.jsba.ThreadTalk.dto.CommentRequest;
import com.jsba.ThreadTalk.service.ThreadTalkServiceImpl;
import com.jsba.ThreadTalk.validation.ValidationFailedException;

@RestController
@RequestMapping("/")
public class ThreadTalkController {

	private ThreadTalkServiceImpl threadTalkServiceImpl;

	public ThreadTalkController(ThreadTalkServiceImpl threadTalkServiceImpl) {
		this.threadTalkServiceImpl = threadTalkServiceImpl;
	}

	@PostMapping("/add")
	public String addComment( @RequestBody CommentRequest commentRequest)throws ValidationFailedException {
		return threadTalkServiceImpl.addComment(commentRequest);
	}

	@GetMapping("/comment/{user}")
	public List<Comment> getAllCommnetByUser(@PathVariable String user) {

		return threadTalkServiceImpl.getAllCommnetByUser(user);
	}
}
