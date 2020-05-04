package com.sagalanov.services.web.login.interfaces;

import com.sagalanov.models.auth.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface WebLoginService {

    String registrationUser(User user, BindingResult bindingResult);

    String loginUser(Model model, String error, String logout);

    String getMainPage(Model model);
}
