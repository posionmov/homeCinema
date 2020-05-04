package com.sagalanov.services.web.login.impl;

import com.sagalanov.models.auth.User;
import com.sagalanov.services.domain.login.interfaces.DomainLoginService;
import com.sagalanov.services.web.login.interfaces.WebLoginService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.sagalanov.constants.auth.AuthConstants.LIST;
import static com.sagalanov.constants.auth.AuthConstants.LIST_VALUE;
import static com.sagalanov.constants.auth.AuthConstants.UPLOAD;
import static com.sagalanov.constants.auth.AuthConstants.UPLOAD_VALUE;
import static com.sagalanov.constants.auth.AuthConstants.ERROR;
import static com.sagalanov.constants.auth.AuthConstants.ERROR_VALUE;
import static com.sagalanov.constants.auth.AuthConstants.MESSAGE;
import static com.sagalanov.constants.auth.AuthConstants.MESSAGE_VALUE;
import static com.sagalanov.constants.auth.AuthConstants.VIEW_LOGIN;
import static com.sagalanov.constants.auth.AuthConstants.PAGES_KEY;
import static com.sagalanov.constants.auth.AuthConstants.VIEW_INDEX;

@Service
public class WebLoginServiceImpl implements WebLoginService {

    private DomainLoginService domainLoginService;

    private static final Map<String, String> PAGES = new HashMap<>();

    static {
        PAGES.put(LIST, LIST_VALUE);
        PAGES.put(UPLOAD, UPLOAD_VALUE);
    }

    public WebLoginServiceImpl(DomainLoginService domainLoginService) {
        this.domainLoginService = domainLoginService;
    }

    @Override
    public String registrationUser(User user, BindingResult bindingResult) {
        return domainLoginService.storeUser(user, bindingResult);
    }

    @Override
    public String loginUser(Model model, String error, String logout) {
        if (!Objects.isNull(error)) {
            model.addAttribute(ERROR, ERROR_VALUE);
        }
        if (!Objects.isNull(logout)) {
            model.addAttribute(MESSAGE, MESSAGE_VALUE);
        }
        return VIEW_LOGIN;
    }

    @Override
    public String getMainPage(Model model) {
        model.addAttribute(PAGES_KEY, PAGES);
        return VIEW_INDEX;
    }
}
