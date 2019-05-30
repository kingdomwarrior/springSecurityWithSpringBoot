package com.amol.spring.boot.security.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

	@GetMapping("/getData")
	public String getData() {
		return "Dhyan kar, Dhyan Kar!!!";
	}
}
