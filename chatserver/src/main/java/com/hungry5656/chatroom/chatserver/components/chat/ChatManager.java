package com.hungry5656.chatroom.chatserver.components.chat;

import com.hungry5656.chatroom.chatserver.components.config.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatManager {
    private static ChatManager instance;
    private ChatManagerConfig thisConfig;
    private Map<String, Chat> activeChatMap;
    private int maximumChatAllowed;

    private ChatManager() {
        activeChatMap = new HashMap<>();
    }

    public static ChatManager getInstance() {
        if (instance == null) {
            instance = new ChatManager();
        }
        return instance;
    }

    public void setConfig(ChatManagerConfig newConfig) {
        thisConfig = newConfig;
    }

    public void addNewChat(Chat newChat) {
        activeChatMap.put(newChat.getChatId(), newChat);
    }

    public boolean deleteChat(String chatId) {
        if (!activeChatMap.containsKey(chatId)) {
            return false;
        }
        activeChatMap.remove(chatId);
        return true;
    }

    public int getTotalChatNum() {
        return activeChatMap.size();
    }


}
