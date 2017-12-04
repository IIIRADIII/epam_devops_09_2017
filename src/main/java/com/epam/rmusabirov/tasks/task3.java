package main.java.com.epam.rmusabirov.tasks;

public class task3 {
    public static void main(String[] args) {
        int val = Integer.parseInt(args[0]);
        if ( val < 3) {
            System.out.println("Green");
        } else if (val < 5){
            System.out.println("Yellow");
        } else {
            System.out.println("Red");
        }
    }
}