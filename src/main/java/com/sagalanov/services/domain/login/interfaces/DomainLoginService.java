package com.sagalanov.services.domain.login.interfaces;

import com.sagalanov.models.auth.User;
import org.springframework.validation.BindingResult;

public interface DomainLoginService {

    String storeUser(User user, BindingResult bindingResult);
}
