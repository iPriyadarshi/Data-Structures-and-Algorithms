class Solution {
    public int minimumCost(int[] nums) {
        // first element of nums must be included.
        int zeroth_ele = nums[0];

        // Other 2 will be 2 minimum elements of nums[1..n-1]
        int firstMin=Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        // Find two smallest elements in nums[1..n-1]
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }
        return zeroth_ele + firstMin + secondMin;
    }
}