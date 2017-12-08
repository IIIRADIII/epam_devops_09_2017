package com.epam.rmusabirov.tasks.WebServer;

import com.epam.se5.lesson26.practice.HttpRequest;
import lombok.*;

import java.io.*;
import java.util.Map;

public class HttpRequestImpl implements HttpRequest, Closeable {

    @Getter
    @Setter
    private InputStream stream;
    private Method method;
    private String uri;
    private String protocol;
    private Map<String, String> headers;

    HttpRequestImpl(InputStream requestStream) throws IOException {
        this.stream = requestStream;
        BufferedReader in = new BufferedReader(new InputStreamReader(this.stream));
        String[] peaces = in.readLine().split(" ");
        try {
            this.method = Method.valueOf(peaces[0]);
        } catch (IllegalArgumentException e) {
            this.method = null;
        }
        this.uri = peaces[1];
        this.protocol = peaces[2];
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public String getURI() {
        return this.uri;
    }

    @Override
    public String getProtocol() {
        return this.protocol;
    }

    @Override
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public String getHeader(String header) {
        return this.headers.get(header);
    }

    @Override
    public InputStream getInputStream() {
        return this.stream;
    }

    @Override
    public void close() throws IOException {
        this.stream.close();
    }
}
