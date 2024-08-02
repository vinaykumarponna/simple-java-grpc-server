package server;

import io.grpc.ServerBuilder;
import io.grpc.examples.helloworld.HelloGrpc;

import java.io.IOException;

public class Server
{
    public static void main( String[] args ) throws Exception {

        System.out.println("starting GRPC Server");
        io.grpc.Server server = ServerBuilder.forPort(9090).addService(
                new HelloService()).build();

        server.start();
        System.out.println("server started at "+ server.getPort());
        server.awaitTermination();
    }
}
