import java.util.ArrayList;
import java.util.List;

public class LuhnAlgorithm {

    /**
     * Validates a number using the Luhn algorithm.
     * Accepts strings with optional spaces or hyphens (e.g., "4539 1488 0343 6467" or "4539-1488-0343-6467").
     * Returns true if the sanitized number passes Luhn, false otherwise.
     */
    public static boolean isValidLuhn(String input) {
        if (input == null)
            return false;

        // 1) Sanitize: keep only digits
        String digits = input.replaceAll("[^0-9]", "");
        if (digits.isEmpty())
            return false;

        // Optional: length guardrails (typical PAN length is 12–19)
        if (digits.length() < 12 || digits.length() > 19) {
            // You can relax this if you want to validate arbitrary identifiers
            return false;
        }

        int sum = 0;
        boolean doubleNext = false; // start from rightmost; its neighbor is doubled

        // 2) Traverse from rightmost to leftmost
        for (int i = digits.length() - 1; i >= 0; i--) {
            int d = digits.charAt(i) - '0';
            if (doubleNext) {
                int doubled = d * 2;
                // 3) Adjust doubles: subtract 9 if >= 10 (or add digits: doubled - 9)
                if (doubled > 9)
                    doubled -= 9;
                sum += doubled;
            } else {
                sum += d;
            }
            doubleNext = !doubleNext;
        }

        // 4) Valid if sum modulo 10 equals 0
        return sum % 10 == 0;
    }

    /**
     * Computes the Luhn check digit for a partial number (without the check digit).
     * Returns the single check digit (0–9).
     */
    public static int computeCheckDigit(String partial) {
        if (partial == null)
            throw new IllegalArgumentException("partial cannot be null");
        String digits = partial.replaceAll("[^0-9]", "");
        if (digits.isEmpty())
            throw new IllegalArgumentException("partial must contain digits");

        int sum = 0;
        boolean doubleNext = true; // For check digit computation, start as if there's a trailing check digit
        for (int i = digits.length() - 1; i >= 0; i--) {
            int d = digits.charAt(i) - '0';
            if (doubleNext) {
                int doubled = d * 2;
                if (doubled > 9)
                    doubled -= 9;
                sum += doubled;
            } else {
                sum += d;
            }
            doubleNext = !doubleNext;
        }
        // The check digit makes (sum + check) % 10 == 0
        return (10 - (sum % 10)) % 10;
    }

    /**
     * Utility: Generates a number by appending the correct Luhn check digit.
     */
    public static String appendCheckDigit(String partial) {
        int check = computeCheckDigit(partial);
        String digits = partial.replaceAll("[^0-9]", "");
        return digits + check;
    }

    /**
     * Optional: Simple issuer identification based on IIN/BIN prefixes.
     * Not exhaustive; provided for convenience in demos.
     */
    public static String guessIssuer(String pan) {
        String d = pan.replaceAll("[^0-9]", "");
        if (d.startsWith("4"))
            return "Visa";
        // MasterCard: 51–55 or 2221–2720
        int prefix2 = d.length() >= 2 ? Integer.parseInt(d.substring(0, 2)) : -1;
        int prefix4 = d.length() >= 4 ? Integer.parseInt(d.substring(0, 4)) : -1;
        if ((prefix2 >= 51 && prefix2 <= 55) || (prefix4 >= 2221 && prefix4 <= 2720))
            return "MasterCard";
        // American Express: 34, 37
        if (d.startsWith("34") || d.startsWith("37"))
            return "American Express";
        // RuPay/others vary; real identification should rely on current BIN tables
        return "Unknown/Other";
    }

    public static void main(String[] args) {
        List<String> samples = new ArrayList<>();
        samples.add("4539 1488 0343 6467"); // Visa sample (valid)
        samples.add("79927398713"); // Classic Luhn example (valid)
        samples.add("79927398714"); // Same, invalid
        samples.add("378282246310005"); // Amex sample (valid)
        samples.add("4111-1111-1111-1111"); // Visa test number (valid)

        for (String s : samples) {
            boolean valid = isValidLuhn(s);
            System.out.printf("Input: %-22s | Luhn valid: %-5s | Issuer: %s%n", s, valid, guessIssuer(s));
        }

        // Demonstrate check digit generation
        String partial = "7992739871"; // without check digit
        int check = computeCheckDigit(partial);
        String full = appendCheckDigit(partial);
        System.out.printf("Partial: %s | Check digit: %d | Full: %s | Luhn valid: %s%n",
                partial, check, full, isValidLuhn(full));
    }
}