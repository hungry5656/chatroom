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

    public ServerRPCServer(int port, URL configFile) throws IOException {
        this(Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create()),
                port, ServerUtil.parseConfig(configFile));
    }

    // gRPC server
    public ServerRPCServer(ServerBuilder<?> serverBuilder, int port, Collection<?> settings) {
        this.port = port;
        this.server = serverBuilder
                .addService(new MessagePushToClientService(settings))
                .build();
    }

    public void start() throws IOException {
        server.start();
        logger.info("GRPC Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    ServerRPCServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private static class MessagePushToClientService extends MessagePushToClientGrpc.MessagePushToClientImplBase {
        private final Collection<?> settings;
        private final String name;

        MessagePushToClientService(Collection<?> settings) {
            this.settings = settings;
            this.name = "services";
        }

        @Override
        public void sendMessage(ChatMessagePublish request, StreamObserver<ChatMessageResponse> responseObserver) {

            ChatMessageResponse response = ChatMessageResponse
                    .newBuilder()
                    .setChatInfo(request.getChatInfo())
                    .setErrorId(0)
                    .setErrorMsg("")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

}