package com.amol.spring.boot.security.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amol.spring.boot.security.springSecurity.model.User;
import com.amol.spring.boot.security.springSecurity.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		CustomUserDetails customUserDetails = null;
		if(user != null) {
			customUserDetails = new CustomUserDetails();
			customUserDetails.setUser(user);
		}else {
			throw new UsernameNotFoundException("User not exist with name:"+userName);
		}
		return null;
	}

}



