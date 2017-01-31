package com.sawa.repository;

import java.util.Optional;

import com.sawa.domain.User;

public interface UserRepository {
	Optional<User> findByName(String username);
}
