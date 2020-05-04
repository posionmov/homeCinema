package com.sagalanov.controllers.auth;

import com.sagalanov.models.auth.User;
import com.sagalanov.services.web.login.interfaces.WebLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.sagalanov.constants.auth.AuthConstants.PATH_REGISTRATION;
import static com.sagalanov.constants.auth.AuthConstants.USER_FORM;
import static com.sagalanov.constants.auth.AuthConstants.VIEW_REGISTRATION;
import static com.sagalanov.constants.auth.AuthConstants.PATH_LOGIN;
import static com.sagalanov.constants.auth.AuthConstants.ROOT;

@Controller
public class LoginController {

    private WebLoginService webLoginService;

    public LoginController(WebLoginService webLoginService) {
        this.webLoginService = webLoginService;
    }

    @GetMapping(PATH_REGISTRATION)
    public String registration(Model model) {
        model.addAttribute(USER_FORM, new User());
        return VIEW_REGISTRATION;
    }

    @PostMapping(PATH_REGISTRATION)
    public String registration(
            @ModelAttribute(USER_FORM) User user,
            BindingResult bindingResult) {
        return webLoginService.registrationUser(user, bindingResult);
    }

    @GetMapping(PATH_LOGIN)
    public String login(Model model, String error, String logout) {
        return webLoginService.loginUser(model, error, logout);
    }

    @GetMapping(ROOT)
    public String welcome(Model model) {
        return webLoginService.getMainPage(model);
    }
}
