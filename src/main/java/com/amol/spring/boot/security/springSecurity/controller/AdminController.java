package com.amol.spring.boot.security.springSecurity.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amol.spring.boot.security.springSecurity.model.User;
import com.amol.spring.boot.security.springSecurity.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	///@RolesAllowed("ROLE_ADMIN")
	@PostMapping("/admin/add")
	public String addUser(@RequestBody User user) {
		String password = user.getPassword();
		String encryptedPassword = bCryptPasswordEncoder.encode(password);
		user.setPassword(encryptedPassword);
		userRepository.save(user);
		return "User added successfully....";
	}
}
