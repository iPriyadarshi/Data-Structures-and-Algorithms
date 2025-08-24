// ================================ Approach 1: Bitwise check (n & 1, n >>= 1) ===============================
class Solution {
    public int hammingWeight(int n) {
        // Time Complexity: O(32) = O(1), since int has 32 bits
        // Space Complexity: O(1)
        int count = 0;
        while (n > 0) {
            count += n & 1; // Check if the last bit is set
            n >>= 1; // Right shift by 1
        }
        return count;
    }
}

// ============================= Approach 2: Brian Kernighan’s Algorithm (n &= (n - 1)) ========================

// class Solution {
//     public int hammingWeight(int n) {
//         // Time Complexity: O(k), where k is the number of set bits (worst case O(32) = O(1))
//         // Space Complexity: O(1)
//         int count = 0;
//         while (n > 0) {
//             n &= (n - 1); // Remove the lowest set bit
//             count++;
//         }
//         return count;
//     }
// }