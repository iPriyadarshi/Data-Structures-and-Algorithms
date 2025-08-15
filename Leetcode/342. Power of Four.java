class Solution {
    /**
     * Determines if a given number is a power of four.
     * 
     * The solution uses three conditions:
     * 1. n > 0: number must be positive
     * 2. n & (n-1) == 0: checks if n is a power of 2
     * 3. (n-1) % 3 == 0: distinguishes powers of 4 from powers of 2
     * 
     * Time Complexity: O(1) - uses only bitwise and arithmetic operations
     * Space Complexity: O(1) - uses only constant extra space
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}