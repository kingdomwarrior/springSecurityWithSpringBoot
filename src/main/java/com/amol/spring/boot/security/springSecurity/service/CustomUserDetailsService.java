package com.amol.spring.boot.security.springSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amol.spring.boot.security.springSecurity.model.User;
import com.amol.spring.boot.security.springSecurity.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> optionalUsers = userRepository.findByName(userName);
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		CustomUserDetails customUserDetails = optionalUsers.map(CustomUserDetails::new).get();
		return customUserDetails;
	}

}
