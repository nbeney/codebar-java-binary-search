package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

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
        final int[] array = parseArrayText(arrayText, ",");
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
    void checkDichotomicIterative(final String arrayText, final String valueText, final String expectedText) {
        check(arrayText, valueText, expectedText, SearchUtils::dichotomicSearchIterative);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SearchUtilsTest/data.csv", delimiter = ':')
    void checkDichotomicRecursive(final String arrayText, final String valueText, final String expectedText) {
        check(arrayText, valueText, expectedText, SearchUtils::dichotomicSearchRecursive);
    }

    private static void check(final String arrayText, final String valueText, final String expectedText, final BiFunction<int[], Integer, Integer> search) {
        final int[] array = parseArrayText(arrayText, ",");
        final int value = Integer.parseInt(valueText);
        final int expected = Integer.parseInt(expectedText);
        final int actual = search.apply(array, value);
        assertEquals(expected, actual);
    }

    private static int[] parseArrayText(String arrayText, final String delimiter) {
        return arrayText == null
                ? new int[]{}
                : Stream.of(arrayText.split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }
}
