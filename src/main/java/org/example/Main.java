package org.example;

public class Main {
    public static void main(String[] args) {
        final int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        final int value = 5;

        System.out.println("linearSearch --> " + SearchUtils.linearSearch(arr, value));
        System.out.println("dichotomicSearchIterative --> " + SearchUtils.dichotomicSearchIterative(arr, value));
        System.out.println("dichotomicSearchRecursive --> " + SearchUtils.dichotomicSearchRecursive(arr, value));
    }
}
