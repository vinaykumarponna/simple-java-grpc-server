package server;

import io.grpc.examples.helloworld.HelloGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class HelloService extends HelloGrpc.HelloImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("request.getName() : "+request.getName());
        responseObserver.onNext(HelloReply.newBuilder().setMessage("server "+request.getName()).build());
        responseObserver.onCompleted();
    }
}
