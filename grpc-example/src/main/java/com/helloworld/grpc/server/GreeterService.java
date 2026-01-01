package com.helloworld.grpc.server;

import com.helloworld.grpc.hello.GreeterGrpc;
import com.helloworld.grpc.hello.HelloReply;
import com.helloworld.grpc.hello.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        String message = "Hello, " + name;

        HelloReply reply = HelloReply.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}


