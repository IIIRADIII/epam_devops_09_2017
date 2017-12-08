package com.epam.rmusabirov.tasks.WebServer;

import com.epam.se5.lesson26.practice.HttpResponse;

import java.io.*;
import java.util.Map;

import lombok.*;

@Getter
@Setter
public class HttpResponseImpl implements HttpResponse, Closeable {

    private OutputStream stream;
    private String protocol;
    private ResponseCode responseCode;
    private Map<String, String> headers;
    private String content;

    HttpResponseImpl(OutputStream stream) {
        this.stream = stream;
        this.setProtocol("HTTP/1.1");
    }

    @Override
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public void setResponseCode(ResponseCode code) {
        this.responseCode = code;
    }

    @Override
    public void setHeader(String name, String value) {
        this.headers.put(name, value);
    }

    @Override
    public void setServerHeader(String value) {
        this.headers.put("Server:", value);
    }

    @Override
    public void setContentType(String value) {
        this.headers.put("Content-Type:", value);
    }

    @Override
    public void setContentLength(String value) {
        this.headers.put("Content-Length:", value);
    }

    @Override
    public OutputStream getOutputStream() {
        return this.stream;
    }

    public void setContent(String content) {
        this.content = content;
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.stream))) {
            writer.write(this.protocol + " " + this.responseCode.toString());
            if (this.headers != null) {
                for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                    writer.write(entry.getKey() + " " + entry.getValue());
                }
            }
            writer.write(this.content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        this.stream.close();
    }
}
