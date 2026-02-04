package org.example.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
  static void main() {

    int port = 3000;
    // int port = 0;

    try (ServerSocket serverSocket =
                 new ServerSocket(port, 64)) {
      // para abrir un servidor que va a "escuchar" la conexión
      // se debe abrir un port que esté disponible sino no funciona
      System.out.println("Starting server on port: " + serverSocket.getLocalPort());

      while (true) {
        Socket socket = serverSocket.accept();
        Thread.ofVirtual()
                .start(
                        () -> {
                          try {
                            handleClient(socket);
                          } catch (IOException e) {
                            throw new RuntimeException(e);
                          }
                });

        // System.out.println(new String(inputStream.readAllBytes()));
        // IO.readln();
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void handleClient(Socket socket) throws IOException {
    try (Socket client = socket) {
      System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());

      InputStream inputStream = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      OutputStream outputStream = socket.getOutputStream();
      PrintWriter writer = new PrintWriter(outputStream, true);

      System.out.println("Message from client: " + reader.readLine());
      writer.println("Hello there from Server");

      socket.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
