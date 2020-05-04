package com.sagalanov.services.domain.login.impl;

import com.sagalanov.components.LoginValidator;
import com.sagalanov.models.auth.User;
import com.sagalanov.services.domain.login.interfaces.DomainLoginService;
import com.sagalanov.services.domain.security.interfaces.SecurityService;
import com.sagalanov.services.domain.security.interfaces.UserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import static com.sagalanov.constants.auth.AuthConstants.REDIRECT;
import static com.sagalanov.constants.auth.AuthConstants.VIEW_REGISTRATION;

@Service
public class DomainLoginServiceImpl implements DomainLoginService {

    private LoginValidator loginValidator;
    private UserService userService;
    private SecurityService securityService;

    public DomainLoginServiceImpl(LoginValidator loginValidator, UserService userService, SecurityService securityService) {
        this.loginValidator = loginValidator;
        this.userService = userService;
        this.securityService = securityService;
    }

    @Override
    public String storeUser(User user, BindingResult bindingResult) {
        loginValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return VIEW_REGISTRATION;
        }
        String password = user.getPassword();
        userService.save(user);
        securityService.autoLogin(user.getUsername(), password);
        return REDIRECT;
    }
}
