package com.epam.rmusabirov.tasks.WebServer;

import com.epam.se5.lesson26.practice.HttpProcessor;
import com.epam.se5.lesson26.practice.HttpRequest;
import com.epam.se5.lesson26.practice.HttpResponse;

import java.io.*;
import java.net.Socket;


public class HttpProcessorImpl implements HttpProcessor, Closeable {

    private Socket socket;

    @Override
    public void process(Socket socket) throws IOException {
        this.socket = socket;
        try (HttpRequestImpl request = new HttpRequestImpl(this.socket.getInputStream()); HttpResponseImpl response = new HttpResponseImpl(this.socket.getOutputStream())) {
            if (request.getMethod() != HttpRequest.Method.GET || request.getMethod() == null) {
                response.setResponseCode(HttpResponse.ResponseCode.BAD_REQUEST);
                response.setContent("");
            }
            //TODO need to implement additional logic in order to return actual data.
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public void close() throws IOException {
        this.socket.close();
    }
}
