// ================================================ Approach 1: Brute-Force ===========================================

class Solution {
    /* Time Complexity: O(n³) - Using three nested loops to check all possible triplets
     * Space Complexity: O(1) - Using only constant extra space
     * 
     * Explanation: This approach checks every possible combination of three numbers (i,j,k)
     * where i < j < k and verifies if they form an arithmetic sequence with the given difference.
     * It's straightforward but inefficient for large inputs.
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((nums[j] - nums[i]) == diff && (nums[k] - nums[j]) == diff) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

// ========================================== Approach 2: Two-Pointer ===============================================

// class Solution {
//     /* Time Complexity: O(n²) - Although we use while loop instead of nested for loops,
//      *                         j and k pointers can still move up to n positions for each i
//      * Space Complexity: O(1) - Using only constant extra space
//      * 
//      * Explanation: This approach uses three pointers to find triplets. It leverages
//      * the fact that the array is sorted and moves the pointers based on whether the
//      * differences are less than or greater than the required difference.
//      * When differences match, we increment count and move pointers accordingly.
//      */
//     public int arithmeticTriplets(int[] nums, int diff) {
//         int count = 0;
//         int n = nums.length;

//         for (int i = 0; i < n; i++) {
//             int j = i + 1;
//             int k = j + 1;

//             while (j < n && k < n) {
//                 int firstDiff = nums[j] - nums[i];
//                 int secondDiff = nums[k] - nums[j];

//                 if (firstDiff < diff) {
//                     j++;
//                     k = Math.max(k, j + 1);
//                 } else if (firstDiff > diff) {
//                     i++;
//                     j = i + 1;
//                     k = j + 1;
//                 } else {
//                     if (secondDiff < diff) {
//                         k++;
//                     } else if (secondDiff > diff) {
//                         j++;
//                         k = Math.max(k, j + 1);
//                     } else {
//                         count++;
//                         j++;
//                         k = Math.max(k, j + 1);
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }

// ============================================== Approach 3: HashMap ===========================================

// class Solution {
//     /* HashMap Approach
//      * Time Complexity: O(n) - One pass to fill HashMap and one pass to check triplets
//      * Space Complexity: O(n) - Using HashMap to store n elements
//      * 
//      * Explanation: This approach uses a HashMap to store all numbers for O(1) lookup.
//      * For each number x, we check if x+diff and x+2*diff exist in the HashMap.
//      * If both exist, we've found a valid arithmetic triplet.
//      * This is the most efficient approach in terms of time complexity.
//      */
//     public int arithmeticTriplets(int[] nums, int diff) {
//         HashMap<Integer, Boolean> map = new HashMap<>();
//         int count = 0;

//         // Mark all numbers as present
//         for (int num : nums) {
//             map.put(num, true);
//         }

//         // Check for triplets
//         for (int num : nums) {
//             if (map.containsKey(num + diff) && map.containsKey(num + 2 * diff)) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }