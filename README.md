# CSE-5306-Project1
Project Assignment 1: Getting Started with Docker and gRPC

Project Overview:
This project implements a cross-language gRPC system using Python and Java. The two server client pairs use the same .proto file, and all sections are containerized using Docker. The four Docker images created are:
- Python Server
- Python Client
- Java Server
- Java Client
-----------------------------------------------------------------------------------------------------------------------------------------
TO RUN THE PROJECT:

(1) First, download the project and access it in the directory.

(2) Build The Docker Images:

First, create a Docker network to allow container-to-container communication:
  
    docker network create grpc-net

(3) Build 4 images:

    docker build -t py-server -f python\server\Dockerfile .
    
    docker build -t py-client -f python\client\Dockerfile .
    
    docker build -t java-server -f java\Dockerfile.server .
    
    docker build --no-cache -t java-client -f java\Dockerfile.client .
    
Note the --no-cache flag is for the Java client to make sure the latest compiled JAR is in the image.

Run The Program

(4) Demo 1: Java Client -> Python Server
Start Python Server: 

    docker run --rm --name pyserver --network grpc-net -e PORT=50051 -p 50051:50051 py-server
    
Run Java Client:

    docker run --rm --network grpc-net -e SERVER_HOST=pyserver -e SERVER_PORT=50051 -e NAME=Evelyn -e CLIENT_LANGUAGE=java java-client

(5) Demo 2: Python Client -> Java Server
Start Java Server:

    docker run --rm --name javaserver --network grpc-net -e PORT=50051 -p 50052:50051 java-server
    
Run Python Client:

    docker run --rm --network grpc-net -e SERVER_HOST=javaserver -e SERVER_PORT=50051 -e NAME=Evelyn -e CLIENT_LANGUAGE=python py-client

Short Explanation of tags:

  --rm -> automatically removes the container when it stops
  
  --name pyserver -> assigns the container the hostname pyserver
  
  --network grpc-net -> attaches the container to the custom Docker network
  
  -e PORT=50051 -> sets an environment variable inside the container
  
  -p -> publishes container port 50051 to host port 50051
  
  -t -> tags the image

-----------------------------------------------------------------------------------------------------------------------------------------
Tools used in this Project:

Protocol Buffers (.proto)
- Define the gRPC service and RPC methods. The same .proto file is used by both Python and Java.
  
grpcio / grpcio-tools (Python)
- grpcio provides the Python gRPC runtime for servers and clients.
- grpcio-tools is used during Docker image build time to generate Python gRPC stubs from the .proto file.
  
Apache Maven (Java)
- Maven manages Java dependencies, compiles source code, runs the Protocol Buffers compiler, and packages the application into a runnable JAR.
  
Maven Protobuf Plugin
- Automatically generates Java gRPC stubs and message classes from the .proto file as part of the Maven build process.
  
Maven Shade Plugin
- Packages the Java application and all dependencies into a single fat JAR suitable for running inside Docker containers. Service metadata is merged to ensure gRPC name resolution works correctly.
  
Docker
- Docker is used to containerize each server and client separately, resulting in four independent images (Python server/client and Java server/client).
  
Docker Networking & Environment Variables
- A custom Docker network allows containers to communicate using container names, while environment variables configure ports and hostnames without hardcoding values.
------------------------------------------------------------------------------------------------------------------------------------------
Maven can be installed via Chocolatey (easier)

    choco install maven -y
    
    mvn -v

Mac & Linux

macOS

    brew install maven
    mvn -v

Linux Ubuntu/Debian

    sudo apt update
    sudo apt install maven
    mvn -v

  

