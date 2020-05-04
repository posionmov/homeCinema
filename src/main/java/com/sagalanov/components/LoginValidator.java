package com.sagalanov.components;

import com.sagalanov.models.auth.User;
import com.sagalanov.services.domain.security.interfaces.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.sagalanov.constants.auth.AuthConstants.USERNAME;
import static com.sagalanov.constants.auth.AuthConstants.USERNAME_ALREADY_EXIST;
import static com.sagalanov.constants.auth.AuthConstants.USERNAME_EMPTY;
import static com.sagalanov.constants.auth.AuthConstants.PASSWORD;
import static com.sagalanov.constants.auth.AuthConstants.PASSWORD_COMFIRM;
import static com.sagalanov.constants.auth.AuthConstants.PASSWORD_EMPTY;
import static com.sagalanov.constants.auth.AuthConstants.PASSWORD_CONFIRM;
import static com.sagalanov.constants.auth.AuthConstants.PASSWORD_COMFIRM_EMPTY;

@Component
public class LoginValidator implements Validator {

    private UserService userService;

    public LoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, USERNAME, USERNAME_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD, PASSWORD_EMPTY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD_CONFIRM, PASSWORD_COMFIRM_EMPTY);
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue(USERNAME, USERNAME_ALREADY_EXIST);
        } else if (!user.getPassword().equals(user.getPasswordConfirm())) {
            errors.rejectValue(PASSWORD, PASSWORD_COMFIRM);
        }
    }
}
