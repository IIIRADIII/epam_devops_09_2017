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

class Printer {
    <T> void printArray(T[] collection){
        for (T item : collection) {
            System.out.println(item.toString());
        }
    }
}