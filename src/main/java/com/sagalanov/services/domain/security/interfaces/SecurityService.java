package com.sagalanov.services.domain.security.interfaces;

public interface SecurityService {

    String findLoggedInUsername(String username);

    void autoLogin(String username, String password);

    String getCurrentUsername();
}
