package com.epam.rmusabirov.tasks.WebServer;

import com.epam.se5.lesson26.practice.HttpProcessor;
import com.epam.se5.lesson26.practice.HttpRequest;
import com.epam.se5.lesson26.practice.HttpResponse;
import com.epam.se5.lesson26.practice.WebServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerImpl implements WebServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(10_000)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); HttpProcessorImpl httpProcessor = new HttpProcessorImpl()) {
                    httpProcessor.process(clientSocket);
                    //                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    //                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
                    //
                    //
                    //                String request = in.readLine();
                    //                String[] peaces = request.split(" ");
                    //                String method = peaces[0];
                    //                String uri = peaces[1];
                    //                String protocol = peaces[2];
                    //
                    //
                    //                System.err.println("process request");
                    //                out.write("HTTP/1.1 200 OK\r\n");
                    //                out.write("Server: SimpleWebServer\r\n");
                    ////                out.write("Content-length: ");
                    //
                    //                out.write("\r\n");
                    //                out.write("<html>\r\n");
                    //                out.write("<body>\r\n");
                    //                out.write("<h1>Hello world!</h1>\r\n");
                    //                out.write("</body>\r\n");
                    //                out.write("</html>\r\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void service(HttpRequest request, HttpResponse response) {

    }
}
