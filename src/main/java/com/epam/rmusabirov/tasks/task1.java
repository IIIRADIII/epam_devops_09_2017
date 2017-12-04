package main.java.com.epam.rmusabirov.tasks;

/**
 * Finds the smallest and the shortest string in args[]
 */
public class task1 {
    public static void main(String[] args) {
        String smallestOne = "";
        String biggestOne = "";
        for (String arg :
                args) {
            if (arg.length() < smallestOne.length()){
                smallestOne = arg;
            }
            if (arg.length() > biggestOne.length()){
                biggestOne = arg;
            }
        }
        System.out.println("Smallest string: " + smallestOne);
        System.out.println("Biggest string: " + biggestOne);

    }
}
