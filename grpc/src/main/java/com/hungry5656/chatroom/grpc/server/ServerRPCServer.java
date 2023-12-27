package com.hungry5656.chatroom.grpc.server;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hungry5656.chatroom.grpc.util.*;

public class ServerRPCServer {
    private static final Logger logger = Logger.getLogger(ServerRPCServer.class.getName());

    private final int port;
    private final Server server;

    public ServerRPCServer(int port) throws IOException {
        this(port, ServerUtil.getDefaultSettingsFile());
    }

    public ServerRPCServer(int port, URL featureFile) throws IOException {
        this(Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create()),
                port, ServerUtil.parseConfig(featureFile));
    }

    // gRPC server
    public ServerRPCServer(ServerBuilder<?> serverBuilder, int port, String name) {
        this.port = port;
        this.server = serverBuilder.addService(new MessagePushToClientService(name))
                .build();
    }

    public

    private static class MessagePushToClientService extends MessagePushToClientGrpc.MessagePushToClientImplBase {
        private final String name;

        MessagePushToClientService(String name) {
            this.name = name;
        }
    }

}