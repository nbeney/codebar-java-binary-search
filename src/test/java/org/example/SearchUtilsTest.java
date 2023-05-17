package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchUtilsTest {

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
        final int[] array = arrayText == null
                ? new int[]{}
                : Stream.of(arrayText.split(",")).mapToInt(Integer::parseInt).toArray();
        final int value = Integer.parseInt(valueText);
        final int expected = Integer.parseInt(expectedText);
        final int actual = search.apply(array, value);
        assertEquals(expected, actual);
    }
}
