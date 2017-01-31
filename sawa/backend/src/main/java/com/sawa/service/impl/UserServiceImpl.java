package com.sawa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sawa.repository.UserRepository;
import com.sawa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userReposistory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userReposistory.findByName(username).orElse(null);
	}

}
