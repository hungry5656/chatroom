package com.hungry5656.chatroom.chatserver.state.connection;

public interface connectionState {
    // STATE:
    // connected: connected-normal, invisible
    // not connected: not connected-normal, closed, error,
    // suspended (connection closed due to inactivity)
}
