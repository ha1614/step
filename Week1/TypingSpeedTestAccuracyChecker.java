public class TypingSpeedTestAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchIndex = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchIndex == -1) {
                firstMismatchIndex = i;
            }
        }

        double accuracy = ((double) matched / original.length()) * 100;

        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matched).append("/").append(original.length());
        result.append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");

        if (firstMismatchIndex == -1) {
            result.append(" | No Mismatches");
        } else {
            result.append(" | First Mismatch at position ").append(firstMismatchIndex + 1);
            result.append(" ('").append(original.charAt(firstMismatchIndex)).append("' vs '");
            result.append(typed.charAt(firstMismatchIndex)).append("')");
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
