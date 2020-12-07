
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void emptyStringShouldReturnsZero() {
        var result = calculator.Add("");
        assertEquals(0, result);
    }

    @Test
    void singleNumberShouldReturnsSameNumber() {
        var result = calculator.Add("1");
        assertEquals(1, result);
    }

    @Test
    void twoNumbersCommaDelimitedReturnsSum(){
        var result = calculator.Add("1,2");
        assertEquals(3,result);
    }

    @Test
    void twoNumbersNewLineDelimitedShouldReturnSum(){
        var result = calculator.Add("1\n2");
    }
}
