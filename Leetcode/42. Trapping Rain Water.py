from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        """
        Calculate the amount of water that can be trapped between blocks.

        Time Complexity: O(n) - where n is the length of the height array
            - Two passes to build leftMax and rightMax arrays: O(n)
            - One final pass to calculate trapped water: O(n)

        Space Complexity: O(n)
            - Two additional arrays (leftMax and rightMax) of size n

        Algorithm:
        1. For each position, water trapped = min(max_left, max_right) - height[i]
        2. Use two arrays to store the maximum heights from the left and right.

        """
        n = len(height)
        if n == 0:
            return 0

        # Initialize arrays to store maximum heights from left and right directions
        leftMax = [0] * n  # leftMax[i] stores the maximum height from 0 to i
        rightMax = [0] * n  # rightMax[i] stores the maximum height from i to n-1

        # Build leftMax array - for each position, store the maximum height seen so far from left
        leftMax[0] = height[0]
        for i in range(1, n):
            leftMax[i] = max(leftMax[i - 1], height[i])

        # Build rightMax array - for each position, store the maximum height seen so far from right
        rightMax[n - 1] = height[n - 1]
        for i in range(n - 2, -1, -1):
            rightMax[i] = max(rightMax[i + 1], height[i])

        # Calculate trapped water at each position
        # Water trapped at position i = min(leftMax[i], rightMax[i]) - height[i]
        result = 0
        for i in range(n):
            water = min(leftMax[i], rightMax[i]) - height[i]
            if water > 0:
                result += water

        return result
