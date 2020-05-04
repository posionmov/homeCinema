package com.sagalanov.services.domain.security.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenAuthenticationService {

    void authenticate(String username, String password, UserDetails userDetails);
}
