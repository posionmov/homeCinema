package com.sagalanov.services.domain.security.impl;

import com.sagalanov.services.domain.security.interfaces.SecurityService;
import com.sagalanov.services.domain.security.interfaces.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    private TokenAuthenticationService tokenAuthenticationService;
    private UserDetailsService userDetailsService;

    public SecurityServiceImpl(
            @Qualifier("tokenAuthenticationServiceImpl") TokenAuthenticationService tokenAuthenticationService,
            @Qualifier("customUserDetailService") UserDetailsService userDetailsService) {
        this.tokenAuthenticationService = tokenAuthenticationService;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public String findLoggedInUsername(String username) {
        UserDetails userDetail = this.userDetailsService.loadUserByUsername(username);
        return userDetail != null ? userDetail.getUsername() : null;
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        tokenAuthenticationService.authenticate(username, password, userDetails);
    }

    @Override
    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
