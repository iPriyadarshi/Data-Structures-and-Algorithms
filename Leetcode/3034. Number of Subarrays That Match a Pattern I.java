// T.C: O(n * m) where n is length of nums and m is length of pattern
// S.C: O(1)

class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int count = 0;

        for (int startIndex = 0; startIndex < n - m; startIndex++) {
            boolean found = true;
            for (int k = 0; k < m; k++) {
                if ((pattern[k] == 1 && nums[startIndex + k + 1] <= nums[startIndex + k])
                        || (pattern[k] == 0 && nums[startIndex + k + 1] != nums[startIndex + k])
                        || (pattern[k] == -1 && nums[startIndex + k + 1] >= nums[startIndex + k])) {
                    found = false;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }
        return count;
    }
}