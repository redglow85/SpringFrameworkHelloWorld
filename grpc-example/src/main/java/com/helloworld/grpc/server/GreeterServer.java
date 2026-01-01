package com.helloworld.grpc.server;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

import java.io.IOException;

public class GreeterServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 9090;
        Server server = NettyServerBuilder.forPort(port)
                .addService(new GreeterService())
                .build()
                .start();

        System.out.println("[gRPC] Server started on port " + port);
        server.awaitTermination();
    }
}


