/**
 * Calculates the minimum number of bit flips required to convert one number to another.
 * The method uses XOR operation to find differing bits and counts them.
 *
 * @param start The starting integer number
 * @param goal The target integer number to convert to
 * @return The minimum number of bit flips needed to convert start to goal
 * 
 * Time Complexity: O(log n) where n is the maximum of start and goal numbers
 *                 (as we need to check each bit in the number)
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR to find differing bits
        int xor = start ^ goal;

        // Count the number of set bits in xor
        int count = 0;
        while (xor != 0) {
            count += xor & 1; // Add 1 if the last bit is set
            xor >>= 1; // Right shift to check next bit
        }
        return count;
    }
}