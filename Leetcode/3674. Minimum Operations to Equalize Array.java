class Solution {
    public int minOperations(int[] nums) {
        // T.C: O(n) - We traverse the array once to check if all elements are equal.
        // S.C: O(1) - We use only constant extra space.
        
        int n = nums.length;
        // If all elements are not initially equal, we can apply the AND operation on the whole array in 'one step' to make all element equal.
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return 1;
            }
        }
        // If all elements are already equal, no operation is needed.
        return 0;
    }
}