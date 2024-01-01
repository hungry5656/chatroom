package com.hungry5656.chatroom.chatserver.cli.command;

public class StopServerCommand implements Command {
    /**
     * @return return true if successful, otherwise return false
     */
    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String toString() {
        return "StopServerCommand";
    }
}
