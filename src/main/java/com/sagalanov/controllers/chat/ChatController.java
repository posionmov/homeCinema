package com.sagalanov.controllers.chat;

import com.sagalanov.models.chat.ChatMessageModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

import static com.sagalanov.constants.chat.ChatConstants.MAP_MESSAGE_ADD_USER;
import static com.sagalanov.constants.chat.ChatConstants.MAP_MESSAGE_SEND_MESSAGE;
import static com.sagalanov.constants.chat.ChatConstants.TOPIC_PUBLIC;
import static com.sagalanov.constants.chat.ChatConstants.SESSION_USER;

@RestController
public class ChatController {

    @MessageMapping(MAP_MESSAGE_SEND_MESSAGE)
    @SendTo(TOPIC_PUBLIC)
    public ChatMessageModel sendMessage(@Payload ChatMessageModel chatMessage) {
        return chatMessage;
    }

    @MessageMapping(MAP_MESSAGE_ADD_USER)
    @SendTo(TOPIC_PUBLIC)
    public ChatMessageModel addUser(@Payload ChatMessageModel chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put(SESSION_USER, chatMessage.getSender());
        return chatMessage;
    }
}
