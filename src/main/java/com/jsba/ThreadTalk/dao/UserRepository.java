package com.jsba.ThreadTalk.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsba.ThreadTalk.dto.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);

}


