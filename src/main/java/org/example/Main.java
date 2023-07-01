package org.example;

import java.util.Arrays;

// comment to trigget github actions

public class Main {
    public static void main(String[] args) {
        demoWithIntegers();
        System.out.println();
        demoWithStrings();

        // Check SearchUtilsTest for more examples.
    }

    private static void demoWithIntegers() {
        final Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        final int value = 5;

        System.out.println("DEMO WITH INTEGERS");
        System.out.println("==================");
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("value = " + value);
        System.out.println("isSorted --> " + SearchUtils.isSorted(array));
        System.out.println("linearSearch --> " + SearchUtils.linearSearch(array, value));
        System.out.println("binarySearchIterative --> " + SearchUtils.binarySearchIterative(array, value));
        System.out.println("binarySearchRecursive --> " + SearchUtils.binarySearchRecursive(array, value));
    }

    private static void demoWithStrings() {
        final String[] array = {"Apple", "Bread", "Cake", "Donuts", "Eggs", "Fish"};
        final String value = "Donuts";

        System.out.println("DEMO WITH STRINGS");
        System.out.println("=================");
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("value = " + value);
        System.out.println("isSorted --> " + SearchUtils.isSorted(array));
        System.out.println("linearSearch --> " + SearchUtils.linearSearch(array, value));
        System.out.println("binarySearchIterative --> " + SearchUtils.binarySearchIterative(array, value));
        System.out.println("binarySearchRecursive --> " + SearchUtils.binarySearchRecursive(array, value));
    }
}
