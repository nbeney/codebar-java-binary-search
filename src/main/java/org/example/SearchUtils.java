package org.example;

public class SearchUtils {
    public static <T extends Comparable> int linearSearch(final T[] arr, T value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(value) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static <T extends  Comparable> int dichotomicSearchIterative(final T[] arr, T value) {
        if (arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while (start < end) {
            if (value.compareTo(arr[mid]) <= 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }

        return arr[mid] == value ? mid : -1;
    }

    public static <T extends  Comparable> int dichotomicSearchRecursive(T[] elements, T value) {
        return dichotomicSearchRecursiveRun(elements, value, 0, elements.length - 1);
    }

    private static <T extends  Comparable> int dichotomicSearchRecursiveRun(T[] elements, T value, int start, int end) {
        if (start > end) {
            return -1;
        } else if (start == end) {
            return elements[start] == value ? start : -1;
        } else {
            final int mid = (start + end) / 2;
            return value.compareTo(elements[mid]) <= 0
                    ? dichotomicSearchRecursiveRun(elements, value, start, mid)
                    : dichotomicSearchRecursiveRun(elements, value, mid + 1, end);
        }
    }

    public static <T extends Comparable> boolean isSorted(final T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
