/**
 * Calculates the Hamming distance between two integers x and y.
 * The Hamming distance is the number of positions at which the corresponding
 * bits are different.
 *
 * Algorithm:
 * 1. XOR the two numbers to get bits that differ
 * 2. Count the number of set bits (1s) in the XOR result
 *
 * @param x first integer
 * @param y second integer
 * @return the Hamming distance between x and y
 *
 * Time Complexity: O(1) since integers have fixed number of bits (32 in Java)
 * Space Complexity: O(1) as only constant extra space is used
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count += xor & 1; // Add 1 if the last bit is set
            xor >>= 1; // Shift right to check next bit
        }
        return count;
    }
}