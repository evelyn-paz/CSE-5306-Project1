import os
import time
import socket
from concurrent import futures

import grpc

# Generated at build time into /app/gen
import project1_pb2
import project1_pb2_grpc

# implements the gRPC service from the proto file
class CrossLangService(project1_pb2_grpc.CrossLangServiceServicer):
    
    def SayHello(self, request, context):
        hostname = socket.gethostname()
        now = int(time.time())
        msg = (
            f"Hello, {request.name}! "
            f"(client_language={request.client_language}) "
            f"from PYTHON server"
        )
        return project1_pb2.HelloReply(
            message=msg,
            server_language="python",
            hostname=hostname,
            unix_time=now,
        )


def serve():
    # environment var for docker compatibility
    port = int(os.getenv("PORT", "50051"))

    # create a gRPC server
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))

    # Register the service with gRPC server
    project1_pb2_grpc.add_CrossLangServiceServicer_to_server(
        CrossLangService(), server
    )

    server.add_insecure_port(f"0.0.0.0:{port}")

    print(f"[python-server] listening on 0.0.0.0:{port}")
    server.start()
    server.wait_for_termination()



if __name__ == "__main__":
    serve()
