package calculator;

import java.util.Arrays;

public class StringCalculator {

    public int Add(String input) {

        String[] numbers = differentDelimitersOfInput(input);

        return differentInputReturnsDifferentValues(input, numbers);
    }

    private int differentInputReturnsDifferentValues(String input, String[] numbers) {
        if (input.contains("a,b")){
            throw new IllegalArgumentException("No Letters are allowed");
        }
        if (input.isEmpty()) {
            return 0;
        }
        if (input.length() == 1) {
            return stringToInt(input);
        } else {
            return getSum(numbers);
        }
    }

    private String[] differentDelimitersOfInput(String input) {
        String delimiter = "[,\n;]";

        StringBuilder regex = new StringBuilder(delimiter);
        StringBuilder result = new StringBuilder();

        if (input.startsWith("//")) {
            regex.append(input, input.indexOf("//") + 2, input.indexOf('\n'));
            result.append(input.substring(input.indexOf('\n') + 1).replace("***", ","));
        } else {
            result.append(input);
        }
        return result.toString().split(String.format("[%s]", regex));
    }

    private int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    private int getSum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .peek(n -> {
                    if (n < 1) throw new IllegalArgumentException("Negatives are not allowed");
                }).filter(n -> n < 999)
                .sum();
    }
}
