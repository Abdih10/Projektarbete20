
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
            "-1,-2,3"
    })
    void whenInputIsNegativeNumbersThrowIllegalArgumentException(String negative) {

        assertThrows(IllegalArgumentException.class, () -> calculator.Add(negative));
    }

    @Test
    void singleNumberShouldReturnsSameNumber() {
        var result = calculator.Add("1");
        assertEquals(1, result);
    }

    @Test
    void twoNumbersCommaDelimitedReturnsSum() {
        var result = calculator.Add("1,2");
        assertEquals(3, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3\n3",
            "1\n2\n3"
    })
    void singleOrTwoNewLinesDelimitedShouldReturnsSum(String numbers) {
        var result = calculator.Add(numbers);
        assertEquals(6, result);
    }

    @Test
    void threeDelimitedCommaReturnsSum() {
        var result = calculator.Add("1,2,3");
        assertEquals(6, result);
    }

    @Test
    void ignoresNumberGreaterThan1000() {
        var result = calculator.Add("10,20,1005");
        assertEquals(30, result);
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
