class Solution {
    // Time Complexity: O(n * log(n)), where n is the input number
    // - Outer loop runs n times
    // - notContainsZero() takes O(log n) time as it processes each digit
    // Space Complexity: O(1), only uses constant extra space
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int a = i;
            int b = n - i;
            if (notContainsZero(a) && notContainsZero(b)) {
                return new int[] { a, b };
            }
        }
        // Fallback return, though the problem guarantees a solution exists
        return new int[] { -1, -1 };
    }

    private boolean notContainsZero(int n) {
        while (n > 0) {
            if (n % 10 == 0)
                return false;
            n /= 10;
        }
        return true;
    }
}