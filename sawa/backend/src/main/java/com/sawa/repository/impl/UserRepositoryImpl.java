package com.sawa.repository.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.sawa.domain.User;
import com.sawa.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private List<User> users = Arrays.asList(
			new User("admin", "admin", Arrays.asList("ROLE_USER", "ROLE_ADMIN")),
			new User("user", "user", Arrays.asList("ROLE_USER")));

	public Optional<User> findByName(String username) {

		for (User user : users) {
			if (user.getUsername().equals(username))
				return Optional.ofNullable(user);
		}

		throw new UsernameNotFoundException("No user found for username :" + username);

	}
}
