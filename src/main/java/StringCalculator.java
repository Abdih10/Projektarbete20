import java.util.Arrays;

public class StringCalculator {
    private final String delimiter = "[,\n]";

    public int Add(String input) {
        String[] numbers = input.split(delimiter);


        if (input.isEmpty()) {
            return 0;
        }
        if (input.length() == 1) {
            return StringToInt(input);
        } else {
            return getSum(numbers);
        }
    }

    private int StringToInt(String input) {
        return Integer.parseInt(input);
    }

    private int getSum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(this::StringToInt).peek(n ->{
            if (n < 0) throw new IllegalArgumentException("Negatives are not allowed");
        }).filter(n -> n <= 1000).sum();
    }
}
