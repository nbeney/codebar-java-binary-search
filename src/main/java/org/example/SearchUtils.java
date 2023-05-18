package org.example;

public class SearchUtils {
    public static int linearSearch(final int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int dichotomicSearchIterative(final int[] arr, int value) {
        if (arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while (start < end) {
            if (value <= arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }

        return arr[mid] == value ? mid : -1;
    }

    public static int dichotomicSearchRecursive(int[] elements, int value) {
        return dichotomicSearchRecursiveRun(elements, value, 0, elements.length - 1);
    }

    private static int dichotomicSearchRecursiveRun(int[] elements, int value, int start, int end) {
        if (start > end) {
            return -1;
        } else if (start == end) {
            return elements[start] == value ? start : -1;
        } else {
            final int mid = (start + end) / 2;
            return value <= elements[mid]
                    ? dichotomicSearchRecursiveRun(elements, value, start, mid)
                    : dichotomicSearchRecursiveRun(elements, value, mid + 1, end);
        }
    }

    public static boolean isSorted(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
