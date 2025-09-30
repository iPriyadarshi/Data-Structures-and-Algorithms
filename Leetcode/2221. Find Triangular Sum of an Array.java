// =============================================== Approach 1: Recursion ===============================================
// T.C: O(n^2)
// S.C: O(n) as we are creating a new array of size n-1 in each recursive call

class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] newNums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            newNums[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return triangularSum(newNums);
    }
}

// ================================================ Approach 2: Iterative ==============================================
// T.C: O(n^2)
// S.C: O(1)

// class Solution {
//     public int triangularSum(int[] nums) {
//         int n = nums.length;
//         while (n > 1) {
//             for (int i = 0; i < n - 1; i++) {
//                 nums[i] = (nums[i] + nums[i + 1]) % 10;
//             }
//             n--;
//         }
//         return nums[0];
//     }
// }