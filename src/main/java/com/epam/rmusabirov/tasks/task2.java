package main.java.com.epam.rmusabirov.tasks;

/**
 * Finds runner with the best result
 */
public class task2 {
    public static void main(String[] args) {
        String[] names = { "Elena", "Thomas", "Hamilton","Vasya", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] times = { 341, 273, 278,3, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
        int firstPlaceIndex = 0;
        int firstTime = times[0];
        for (int i = 1; i < times.length; i++) {
            if (times[i] < firstTime){
                firstPlaceIndex = i;
                firstTime = times[i];
            }
        }
        System.out.println("Best runner: " + names[firstPlaceIndex] + " with result of " + firstTime + " second.");
    }
}
