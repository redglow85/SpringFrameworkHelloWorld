package com.helloworld.grpc.client;

import com.helloworld.grpc.hello.GreeterGrpc;
import com.helloworld.grpc.hello.HelloReply;
import com.helloworld.grpc.hello.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreeterClient {
    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "World";

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        try {
            GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
            HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName(name).build());
            System.out.println("[gRPC] reply.message=" + reply.getMessage());
        } finally {
            channel.shutdownNow();
        }
    }
}


