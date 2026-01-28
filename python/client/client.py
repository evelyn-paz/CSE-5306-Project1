import os
import grpc

import project1_pb2
import project1_pb2_grpc


def main():
    host = os.getenv("SERVER_HOST", "localhost")
    port = os.getenv("SERVER_PORT", "50051")
    name = os.getenv("NAME", "Evelyn")
    client_lang = os.getenv("CLIENT_LANGUAGE", "python")

    target = f"{host}:{port}"
    print(f"[python-client] connecting to {target}")

    with grpc.insecure_channel(target) as channel:
        # Stub class name is based on the service name in the proto: CrossLangService
        stub = project1_pb2_grpc.CrossLangServiceStub(channel)

        # Request message class is based on message name: HelloRequest
        req = project1_pb2.HelloRequest(name=name, client_language=client_lang)

        resp = stub.SayHello(req)

    print("[python-client] reply:")
    print(f"message         = {resp.message}")
    print(f"server_language = {resp.server_language}")
    print(f"hostname        = {resp.hostname}")
    print(f"unix_time       = {resp.unix_time}")


if __name__ == "__main__":
    main()
