class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + nums[i]) % n;
            if (newIndex < 0) {
                newIndex += n;
            }
            result[i] = nums[newIndex];
        }

        return result;
    }
}
