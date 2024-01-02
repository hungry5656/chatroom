package com.hungry5656.chatroom.chatserver.components.chat;

import com.hungry5656.chatroom.chatserver.components.Message.ChatMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.*;

public abstract class Chat {
    private String chatId;
    private List<Integer> userIdList;
    private int messageNum;
    private LocalDateTime lastMessageDate;
    private List<ChatMessage> cachedMessages;

    public Chat() {
        cachedMessages = new ArrayList<>();
    }

    public Chat(String chatId) {
        this.chatId = chatId;
    }

    public void addMessage(ChatMessage newMessage) {
        cachedMessages.add(newMessage);
        messageNum++;
    }

    public List<ChatMessage> retrieveMessages(int messageNum) {
        Stream.of(cachedMessages).collect(Collections.)
    }

    public String getChatId() {
        return chatId;
    }
}
