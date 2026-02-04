package org.example.socket;

import java.io.*;
import java.net.Socket;

public class SimpleClient {
  static void main() {

    int port = 3000;
    String serverIp = "127.0.0.1";

    try (Socket socket = new Socket(serverIp, port)) {

      InputStream inputStream = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      OutputStream outputStream = socket.getOutputStream();
      PrintWriter writer = new PrintWriter(outputStream, true);

      // Send message to the server
      writer.println("Hello from Client");

      System.out.println("Message from server: " + reader.readLine());

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
