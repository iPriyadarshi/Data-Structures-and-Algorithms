// T.C: O(n)
// S.C: O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int totalSlices = 0;
        int currentSlices = 0;
        // currentSlices keeps track of the number of arithmetic slices ending at the current index
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                currentSlices++;
                totalSlices += currentSlices;
            } else {
                currentSlices = 0;
            }
        }

        return totalSlices;
    }
}