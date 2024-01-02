package com.hungry5656.chatroom.chatserver.components.user;

import com.hungry5656.chatroom.chatserver.components.chat.*;

import java.util.List;

public class User {
    private final int userId;
    private final String username;
    private List<Chat> activeChatListPerUser;


    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public int addDependencies(){
        return -1;
    }
    public int instantiateConnection


}
