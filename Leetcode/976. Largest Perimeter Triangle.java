/**
 * Finds the largest possible perimeter of a triangle using three sides from the given array.
 * The solution uses the triangle inequality theorem: the sum of any two sides must be greater
 * than the third side for a valid triangle.
 *
 * Time Complexity: O(n log n) due to the sorting operation
 * Space Complexity: O(1) as only constant extra space is used
 */
class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array in ascending order

        // Traverse from the end to find the largest valid triangle
        for (int i = n - 1; i >= 2; i--) {
            // Check triangle inequality: a + b > c
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0; // No valid triangle found
    }
}