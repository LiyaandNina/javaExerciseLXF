package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.SocketHandler;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ExecutorService es = Executors.newFixedThreadPool(6);
             ServerSocket serverSocket = new ServerSocket(6666);) {
            System.out.println("Server is running...");
            for (;;) {
                Socket socket = serverSocket.accept();
                es.submit(new Handler(socket));
            }
        }
    }
}

class Handler extends Thread {
    private Socket ss;

    public Handler(Socket ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        try (InputStream input = ss.getInputStream()) {
            try (OutputStream output = ss.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                ss.close();
            } catch (IOException ioe) {
            }
            System.out.println("Client disconnected...");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        writer.write("hello!\n");
        writer.flush();
        for (;;) {
            String s = reader.readLine();
            if (s.equalsIgnoreCase("bye")) {
                writer.write("Bye\n");
                writer.flush();
                break;
            }
            writer.write("Ok, " + s + "\n");
            writer.flush();
        }
    }
}