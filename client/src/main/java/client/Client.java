package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.HelloGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

import java.io.IOException;

public class Client
{
    public static void main( String[] args ) throws Exception {

        //ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        // stubs - generate from proto

        HelloGrpc.HelloBlockingStub stub = HelloGrpc.newBlockingStub(channel);

        HelloRequest req = HelloRequest.newBuilder().setName("Linux").build();
        HelloReply res = stub.sayHello(req);
        System.out.println("res.getMessage() : "+res.getMessage());
    }
}
