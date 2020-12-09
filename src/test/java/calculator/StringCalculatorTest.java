package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void emptyStringShouldReturnsZero() {
        var result = calculator.Add("");
        assertEquals(0, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-1,2",
            "-1,-2,3",
            "-2,-2,-1,-1"
    })
    void whenInputIsNegativeNumbersThrowIllegalArgumentException(String negative) {

        assertThrows(IllegalArgumentException.class, () -> calculator.Add(negative));
    }

    @Test
    void singleNumberShouldReturnsSameNumber() {
        var result = calculator.Add("1");
        assertEquals(1, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,5",
            "2,2,2"
    })
    void commaWithTwoAndThreeNumbersDelimitedReturnsSum(String numbers) {
        var result = calculator.Add(numbers);
        assertEquals(6, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3\n3",
            "1\n2\n3"
    })
    void newLineWithTwoAndThreeNumbersDelimitedReturnsSum(String numbers) {
        var result = calculator.Add(numbers);
        assertEquals(6, result);
    }

    @Test
    void newLineAndCommaDelimitedReturnsSum() {
        var result = calculator.Add("1,2\n3");
        assertEquals(6, result);
    }

    @Test
    void ignoresNumberGreaterThan1000() {
        var result = calculator.Add("999,20,1005");
        assertEquals(20, result);
    }

    @Test
    void differentDelimitedReturnsSum() {
        var result = calculator.Add("//;\n1;2");
        assertEquals(3, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//[***]\n1***2***3",
            "//[*][%]\n1*2%3",
            "//[**][%%]\n1*2%3"
    })
    void anyLengthDelimitedShouldReturnSum(String differentDelimiter) {
        var result = calculator.Add(differentDelimiter);
        assertEquals(6, result);
    }
}
