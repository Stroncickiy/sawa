package com.sawa.auth;

import com.sawa.domain.User;

public interface SecurityContextService {
    User currentUser();
}