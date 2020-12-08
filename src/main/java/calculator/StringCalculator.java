package calculator;

import java.util.Arrays;

public class StringCalculator {

    public int Add(String input) {

        String[] numbers = differentDelimitersOfInput(input);

        if (input.isEmpty()) {
            return 0;
        }
        if (input.length() == 1) {
            return StringToInt(input);
        } else {
            return getSum(numbers);
        }
    }

    private String[] differentDelimitersOfInput(String input) {
        String delimiter = "[,\n;]";

        StringBuilder regex = new StringBuilder(delimiter);
        StringBuilder result = new StringBuilder();

        if (input.startsWith("//")) {
            regex.append(input, input.indexOf("//") + 2, input.indexOf("\n"));
            result.append(input.substring(input.indexOf("\n") + 1).replace("***", ","));
        } else {
            result.append(input);
        }
        return result.toString().split("[" + regex + "]");
    }

    private int StringToInt(String input) {
        return Integer.parseInt(input);
    }

    private int getSum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::StringToInt)
                .peek(n -> {
                    if (n < 0) throw new IllegalArgumentException("Negatives are not allowed");
                }).filter(n -> n <= 1000)
                .sum();
    }
}
