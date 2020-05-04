package com.sagalanov.services.domain.security.interfaces;

import com.sagalanov.models.auth.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
