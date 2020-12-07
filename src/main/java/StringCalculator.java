public class StringCalculator {
    private final String delimiter = "[,\n]";
    public int Add(String input) {
        String[] numbers = input.split(delimiter);


        if (input.isEmpty()) {
            return 0;
        }
        if (input.length() == 1){
            return Integer.parseInt(input);
        } else {
            return getSum(numbers);
        }
    }

    private int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
