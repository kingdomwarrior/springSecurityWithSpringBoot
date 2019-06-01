package com.amol.spring.boot.security.springSecurity.controller;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amol.spring.boot.security.springSecurity.model.Role;
import com.amol.spring.boot.security.springSecurity.model.User;
import com.amol.spring.boot.security.springSecurity.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	/*
	 *
	 * Important: if POST method is not working through postman, then you have to read this and follow this, otherwise just ignore.
	 * this is dummy thing.added because postman POST method was not working for spring security
	 * it was asking multiple times User name and password even though I have provided it in the Authorization header.
	 *If you want to just test this application using browser, then u have to use it like below.
	 *
	 @GetMapping("/admin/add") 
	 public String addUser(/* @RequestBody User user *//*)/*{
	 User user = getDummyUser(); 
	 */
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUser(@RequestBody User user) {
		//User user = getDummyUser();
		String password = user.getPassword();
		String encryptedPassword = bCryptPasswordEncoder.encode(password);
		user.setPassword(encryptedPassword);
		userRepository.save(user);
		return "User added successfully....";
	}

	/**
	 * This is just a dummy user created. 
	 * this is created because through postman, I was not ablw to hit the POST endpoint.
	 * 
	 * as a solution, you can create a custom form for login as well as to add the users etc .
	 * 
	 * @return
	 */
	private User getDummyUser() {
		User user = new User();
		user.setUserId(1234);
		user.setEmail("user@user.com");
		user.setName("IAMUser");
		user.setPassword("IAMUser");
		Set<Role> roles = new HashSet<>();
		Role role = new Role();
		role.setRole("USER");
		roles.add(role);
		user.setRoles(roles);
		return user;
	}
}
