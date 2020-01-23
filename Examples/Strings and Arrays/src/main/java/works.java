package main.java;

/**
 * This class is for testing output of Java programming.
 */
public class works {
    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]++);
        }
    }
}
