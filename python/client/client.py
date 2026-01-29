import os
import grpc

import project1_pb2
import project1_pb2_grpc


def main():
    # reads the config from environment variables
    host = os.getenv("SERVER_HOST", "localhost")
    port = os.getenv("SERVER_PORT", "50051")
    name = os.getenv("NAME", "Evelyn")
    client_lang = os.getenv("CLIENT_LANGUAGE", "python")

    target = f"{host}:{port}"
    print(f"[python-client] connecting to {target}")

    # creates gRPC channel to server
    with grpc.insecure_channel(target) as channel:
        # create a stub for CrossLangService
        stub = project1_pb2_grpc.CrossLangServiceStub(channel)

        # builds the request message
        req = project1_pb2.HelloRequest(name=name, client_language=client_lang)
        # calls SayHello RPC
        resp = stub.SayHello(req)

    # Prints response fileds returned by the server
    print("[python-client] reply:")
    print(f"message         = {resp.message}")
    print(f"server_language = {resp.server_language}")
    print(f"hostname        = {resp.hostname}")
    print(f"unix_time       = {resp.unix_time}")


if __name__ == "__main__":
    main()
