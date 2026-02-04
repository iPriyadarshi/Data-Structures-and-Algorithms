class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;

        int peakCount = 0;
        int valleyCount = 0;
        int peakIndex = -1;
        int valleyIndex = -1;

        if (nums[1] <= nums[0]) return false;
        if (nums[n - 1] <= nums[n - 2]) return false;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) return false;

            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peakCount++;
                peakIndex = i;
            }

            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                valleyCount++;
                valleyIndex = i;
            }
        }

        if (peakCount != 1 || valleyCount != 1) return false;

        return peakIndex < valleyIndex;
    }
}
