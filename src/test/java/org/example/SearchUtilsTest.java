package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {
            ":true",
            "1:true",
            "1,1:true",
            "1,2:true",
            "1,2,3:true",
            "1,0:false",
            "1,2,3,0:false",
    }, delimiter = ':')
    void checkIsSorted(final String arrayText, final String expectedText) {
        final Integer[] array = parseArrayText(arrayText, ",");
        final boolean expected = Boolean.parseBoolean(expectedText);
        assertEquals(expected, SearchUtils.isSorted(array));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SearchUtilsTest/data.csv", delimiter = ':')
    void checkLinear(final String arrayText, final String valueText, final String expectedText) {
        check(arrayText, valueText, expectedText, SearchUtils::linearSearch);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SearchUtilsTest/data.csv", delimiter = ':')
    void checkBinaryIterative(final String arrayText, final String valueText, final String expectedText) {
        check(arrayText, valueText, expectedText, SearchUtils::binarySearchIterative);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SearchUtilsTest/data.csv", delimiter = ':')
    void checkBinaryRecursive(final String arrayText, final String valueText, final String expectedText) {
        check(arrayText, valueText, expectedText, SearchUtils::binarySearchRecursive);
    }

    private static void check(final String arrayText, final String valueText, final String expectedText, final BiFunction<Integer[], Integer, Integer> search) {
        final Integer[] array = parseArrayText(arrayText, ",");
        final Integer value = Integer.parseInt(valueText);
        final int expected = Integer.parseInt(expectedText);
        final int actual = search.apply(array, value);
        assertEquals(expected, actual);
    }

    private static Integer[] parseArrayText(String arrayText, final String delimiter) {
        return arrayText == null
                ? new Integer[]{}
                : Arrays.stream(arrayText.split(delimiter)).map(Integer::parseInt).toArray(Integer[]::new);
    }
}
