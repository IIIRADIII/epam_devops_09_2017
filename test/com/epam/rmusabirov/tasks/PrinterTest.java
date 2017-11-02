package com.epam.rmusabirov.tasks;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PrinterTest {
    @Test
    void printArray() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new Printer().printArray(new Integer[]{1, 2, 3,});
        new Printer().printArray(new String[]{"foo", "bar"});
        assertEquals("1" + lineSeparator() + "2" + lineSeparator() + "3" + lineSeparator() + "foo" + lineSeparator() + "bar" + lineSeparator(), outContent.toString());

    }

}