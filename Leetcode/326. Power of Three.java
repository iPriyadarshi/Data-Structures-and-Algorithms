// Approach 1: Iterative Division
// Time Complexity: O(log₃n) - we divide n by 3 until we can't anymore
// Space Complexity: O(1) - only using a single variable
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

// Approach 2: Recursive
// Time Complexity: O(log₃n) - we recursively divide n by 3
// Space Complexity: O(log₃n) - recursive call stack depth
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 1)
            return n == 1;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }
}

// Approach 3: Base-3 String Conversion
// Time Complexity: O(log₃n) - converting to base 3 requires log₃n operations
// Space Complexity: O(log₃n) - storing the base-3 string representation
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;

        StringBuilder nbase3 = new StringBuilder();
        while (n > 0) {
            nbase3.insert(0, n % 3);
            n /= 3;
        }

        if (nbase3.charAt(0) != '1') {
            return false;
        }

        for (int i = 1; i < nbase3.length(); i++) {
            if (nbase3.charAt(i) != '0') {
                return false;
            }
        }

        return true;
    }
}

// Approach 4: Mathematics (Integer Limitation)
// Time Complexity: O(1) - single operation
// Space Complexity: O(1) - constant space
// Note: 1162261467 is 3¹⁹, the largest power of 3 that fits in a 32-bit integer
class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}