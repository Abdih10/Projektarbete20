public class StringCalculator {
    public int Add(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(s);
    }
}
