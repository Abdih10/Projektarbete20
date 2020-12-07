
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    void emptyStringShouldReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        var result = calculator.Add("");
        assertEquals(0, result);
    }

    @Test
    void singleNumberShouldReturnsSameNumber() {
        StringCalculator calculator = new StringCalculator();

        var result = calculator.Add("1");
        assertEquals(1, result);
    }
}
