package com.sagalanov.services.domain.security.impl;

import com.sagalanov.services.domain.security.interfaces.TokenAuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    private AuthenticationManager authenticationManager;

    public TokenAuthenticationServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void authenticate(String username, String password, UserDetails userDetails) {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
        }
    }
}
