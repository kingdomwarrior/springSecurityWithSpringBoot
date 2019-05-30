package com.amol.spring.boot.security.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.spring.boot.security.springSecurity.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUserName(String userName);

}
