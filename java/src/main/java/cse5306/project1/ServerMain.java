package cse5306.project1;

import java.net.InetAddress;
import java.time.Instant;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerMain {

  static class Impl extends CrossLangServiceGrpc.CrossLangServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        //Hostname helps docker to show which container made the request
      String hostname = "unknown";
      try {
        hostname = InetAddress.getLocalHost().getHostName();
      } catch (Exception ignored) {}

      
      long now = Instant.now().getEpochSecond();

      // Builds a readable message showing:
      String msg = "Hello, " + request.getName()
          + "! (client_language=" + request.getClientLanguage() + ") from JAVA server";

      // makes the response message that has the user's name, client & server language
      HelloReply reply = HelloReply.newBuilder()
          .setMessage(msg)
          .setServerLanguage("java")
          .setHostname(hostname)
          .setUnixTime(now)
          .build();

      // sends the response back to the client and completes the RPC
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }
  }

  public static void main(String[] args) throws Exception {
    // Reads the port, so Docker can configure
    int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "50051"));
    // Build and start the gRPC server
    Server server = ServerBuilder.forPort(port)
        .addService(new Impl())
        .build()
        .start();

    System.out.println("[java-server] listening on 0.0.0.0:" + port);
    
    server.awaitTermination();
  }
}
