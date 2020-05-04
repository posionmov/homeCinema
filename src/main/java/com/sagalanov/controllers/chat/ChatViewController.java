package com.sagalanov.controllers.chat;

import com.sagalanov.services.web.chat.interfaces.WebChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.sagalanov.constants.chat.ChatConstants.PATH_CHAT;

@Controller
public class ChatViewController {

    private WebChatService webChatService;

    public ChatViewController(WebChatService webChatService) {
        this.webChatService = webChatService;
    }

    @GetMapping(PATH_CHAT)
    public String getChatView(Model model) {
        return webChatService.getChatView(model);
    }
}
