package com.sagalanov.components;

import com.sagalanov.models.chat.ChatMessageModel;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import static com.sagalanov.constants.chat.ChatConstants.SESSION_USER;
import static com.sagalanov.constants.chat.ChatConstants.TOPIC_PUBLIC;

@Component
public class ChatEventListener {

    private SimpMessageSendingOperations messagingTemplate;

    public ChatEventListener(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get(SESSION_USER);
        if (username != null) {
            ChatMessageModel chatMessage = new ChatMessageModel();
            chatMessage.setType(ChatMessageModel.MessageType.LEAVE);
            chatMessage.setSender(username);
            messagingTemplate.convertAndSend(TOPIC_PUBLIC, chatMessage);
        }
    }
}
