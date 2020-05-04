package com.sagalanov.services.web.chat.impl;

import com.sagalanov.services.domain.security.interfaces.SecurityService;
import com.sagalanov.services.web.chat.interfaces.WebChatService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static com.sagalanov.constants.chat.ChatConstants.PATH_CHAT;
import static com.sagalanov.constants.chat.ChatConstants.SESSION_USER;

@Service
public class WebChatServiceImpl implements WebChatService {

    private SecurityService securityService;

    public WebChatServiceImpl(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public String getChatView(Model model) {
        model.addAttribute(SESSION_USER, securityService.getCurrentUsername());
        return PATH_CHAT;
    }
}
