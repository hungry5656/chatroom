package com.hungry5656.chatroom.chatserver.components.chat;

import java.time.LocalDateTime;
import java.util.List;
import com.hungry5656.chatroom.chatserver.components.Message.*;

abstract class Chat {
    private int chatId;
    private List<Integer> userIdList;
    private int messageNum;
    private LocalDateTime lastMessageDate;
    private List<ChatMessage> cachedMessages;
    public void updateMessage() {

    }

}
