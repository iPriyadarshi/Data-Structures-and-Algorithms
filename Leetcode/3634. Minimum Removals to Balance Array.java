class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;

        Arrays.sort(nums);

        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < n; j++) {
            while (nums[j] > (long) k * nums[i]) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return n - maxLen;
    }
}
