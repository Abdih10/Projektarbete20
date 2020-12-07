import java.util.Arrays;

public class StringCalculator {
    private final String delimiter = "[,\n;]";

    public int Add(String input) {
        StringBuilder regex = new StringBuilder(delimiter);
        StringBuilder result = new StringBuilder();

        if (input.startsWith("//")){
           regex.append(input,input.indexOf("//"), input.indexOf(";"));
           result.append(input.substring(input.indexOf("\n")+1));
        }
        String[] numbers = result.toString().split(delimiter);


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
