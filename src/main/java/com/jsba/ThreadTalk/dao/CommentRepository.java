package com.jsba.ThreadTalk.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsba.ThreadTalk.dto.Comment;
import com.jsba.ThreadTalk.dto.User;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	
	 List<Comment> findByReceivedByUser(User user);
	

}
