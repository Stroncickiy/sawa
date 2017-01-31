package com.sawa.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sawa.domain.User;
import com.sawa.repository.impl.UserRepositoryImpl;

@Service
public class SecurityContextServiceImpl implements SecurityContextService {

	private final UserRepositoryImpl userRepository;

	@Autowired
	public SecurityContextServiceImpl(UserRepositoryImpl userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User currentUser() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final Optional<User> currentUser = userRepository.findByName(authentication.getName());
		return currentUser.orElse(null);
	}
}
