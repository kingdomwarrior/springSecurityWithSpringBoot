package com.amol.spring.boot.security.springSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.spring.boot.security.springSecurity.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByName(String username);
}
