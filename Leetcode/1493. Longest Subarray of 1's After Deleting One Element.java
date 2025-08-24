class Solution {
    /**
     * Finds the length of the longest subarray containing only 1's after deleting exactly one element from the input array.
     * Uses sliding window approach to maintain a window with at most one zero.
     *
     * Time Complexity: O(n) where n is the length of input array nums
     * Space Complexity: O(1) as only constant extra space is used
     */
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}