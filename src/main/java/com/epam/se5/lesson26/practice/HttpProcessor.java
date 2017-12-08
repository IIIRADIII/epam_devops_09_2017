package com.epam.se5.lesson26.practice;

import java.io.IOException;
import java.net.Socket;

public interface HttpProcessor {
    void process(Socket socket) throws IOException;
}
