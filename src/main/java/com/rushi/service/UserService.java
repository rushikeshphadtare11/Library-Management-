package com.rushi.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rushi.model.User;
import com.rushi.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
	
}
