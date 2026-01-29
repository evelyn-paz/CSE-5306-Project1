package cse5306.project1;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

// java gRPC client
public class ClientMain {
  public static void main(String[] args) {
    // Reads environment variable
    String host = System.getenv().getOrDefault("SERVER_HOST", "localhost");
    String port = System.getenv().getOrDefault("SERVER_PORT", "50051");
    String name = System.getenv().getOrDefault("NAME", "Evelyn");
    String clientLang = System.getenv().getOrDefault("CLIENT_LANGUAGE", "java");

    int portNum = Integer.parseInt(port);

    System.out.println("[java-client] MARKER vADDR: using forAddress()");
    System.out.println("[java-client] connecting to " + host + ":" + portNum);

    // Creates a gRPC channel to the server
    ManagedChannel channel = ManagedChannelBuilder
        .forAddress(host, portNum)
        .usePlaintext()
        .build();
    
    CrossLangServiceGrpc.CrossLangServiceBlockingStub stub =
        CrossLangServiceGrpc.newBlockingStub(channel);

    // Build request
    HelloRequest request = HelloRequest.newBuilder()
        .setName(name)
        .setClientLanguage(clientLang)
        .build();

    // Call RPC
    HelloReply resp = stub.sayHello(request);

    // print response
    System.out.println("[java-client] reply:");
    System.out.println("message         = " + resp.getMessage());
    System.out.println("server_language = " + resp.getServerLanguage());
    System.out.println("hostname        = " + resp.getHostname());
    System.out.println("unix_time       = " + resp.getUnixTime());

    channel.shutdownNow();
  }
}
