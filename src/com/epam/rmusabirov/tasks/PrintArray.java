package com.epam.rmusabirov.tasks;

public class PrintArray {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        printer.printArray(intArray);
        printer.printArray(stringArray);
    }
}

/**
 * Provides ability to output array of objects in console
 */
class Printer {

    /**
     * Outputs every item of arr array in console from new line using toString() method.=
     *
     * @param arr
     * @param <T>
     */
    <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.println(item.toString());
        }
    }
}