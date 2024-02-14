package com.jsba.ThreadTalk.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsba.ThreadTalk.dao.CommentRepository;
import com.jsba.ThreadTalk.dao.UserRepository;
import com.jsba.ThreadTalk.dto.Comment;
import com.jsba.ThreadTalk.dto.CommentRequest;
import com.jsba.ThreadTalk.dto.User;
import com.jsba.ThreadTalk.validation.ValidationFailedException;

@Service
public class ThreadTalkServiceImpl {

	
	private UserRepository userRepository;
	
	private CommentRepository commentRepository;


public ThreadTalkServiceImpl(CommentRepository commentRepository,UserRepository userRepository) {
		this.commentRepository=commentRepository;
		this.userRepository=userRepository;
	}

	public String addComment(CommentRequest commentRequest) throws ValidationFailedException {

		if (commentRequest.getCommentFrom() == null || commentRequest.getCommentFrom().isBlank()
				|| commentRequest.getCommentTo() == null || commentRequest.getCommentTo().isBlank()) {
			throw new ValidationFailedException("Invalid Request");
		}

		User senderUser = userRepository.findByName(commentRequest.getCommentFrom());

		if (senderUser == null) {
			senderUser = new User();
			senderUser.setName(commentRequest.getCommentFrom());
			userRepository.save(senderUser);
		}

		User receiverUser = userRepository.findByName(commentRequest.getCommentTo());
		if (receiverUser == null) {
			receiverUser = new User();
			receiverUser.setName(commentRequest.getCommentTo());
			userRepository.save(receiverUser);
		}

		Comment comment = new Comment();
		comment.setMessage(commentRequest.getMessage());
		comment.setCommentDateAndTime(LocalDateTime.now());
		comment.setPostedByUser(senderUser);
		comment.setReceivedByUser(receiverUser);

		commentRepository.save(comment);

		return "Comment added successfully";
	}

	public List<Comment> getAllCommnetByUser(String user) {
		User userDetails = userRepository.findByName(user);

		if (user != null) {
			return commentRepository.findByReceivedByUser(userDetails);
		}

		return Collections.emptyList();
	}

}
