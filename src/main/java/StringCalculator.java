public class StringCalculator {
    public int Add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(input);
    }
}
