package com.hungry5656.chatroom.chatserver.core;

import com.hungry5656.chatroom.grpc.server.*;

class ChatServer {
    private static ServerRPCServer gRPCServer;

    public static void main(String[] args) throws Exception {
        gRPCServer = new ServerRPCServer(8980);
        gRPCServer.start();
        gRPCServer.blockUntilShutdown();
    }

    public void start() throws Exception {
        if (gRPCServer != null){
            gRPCServer.start();
        }
    }

    public void stop() throws InterruptedException {
        if (gRPCServer != null) {
            gRPCServer.stop();
        }
    }

}