package org.example;

public class Main {
    public static void main(String[] args) {
        final Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        final int value = 5;

        System.out.println("linearSearch --> " + SearchUtils.linearSearch(arr, value));
        System.out.println("binarySearchIterative --> " + SearchUtils.binarySearchIterative(arr, value));
        System.out.println("binarySearchRecursive --> " + SearchUtils.binarySearchRecursive(arr, value));
        System.out.println("isSorted --> " + SearchUtils.isSorted(arr));

        // Check SearchUtilsTest for more examples.
    }
}
