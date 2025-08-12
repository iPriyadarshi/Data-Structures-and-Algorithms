from typing import List


class Solution:
    """
    Time Complexity: O(n) - where n is the length of the height array
    Space Complexity: O(1) - only uses two pointers and a few variables
    
    Returns:
        int: The maximum amount of water that can be contained between two lines

    """

    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        left_pointer = 0
        right_pointer = n - 1
        maxWater = 0
        while left_pointer < right_pointer:
            w = right_pointer - left_pointer
            h = min(height[left_pointer], height[right_pointer])
            area = w * h
            maxWater = max(maxWater, area)

            if height[left_pointer] > height[right_pointer]:
                right_pointer -= 1
            else:
                left_pointer += 1
        return maxWater
