package com.sawa.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No user")
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -4921536396203947012L;
}