public class StringCalculator {
    public int Add(String input) {
        String[] numbers = input.split(",");


        if (input.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        }
    }
}
