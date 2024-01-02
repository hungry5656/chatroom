package com.hungry5656.chatroom.chatserver.components.user;

import com.hungry5656.chatroom.chatserver.components.chat.ChatManager;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private static UserManager instance;
    private Map<Integer, User> activeUserList;
    private UserManager(){
        activeUserList = new HashMap<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
}
