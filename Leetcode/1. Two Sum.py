from typing import List

# Approach 1: Brute Force
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        Brute-force approach:
        Check every pair of elements to find the two that sum to the target.
        Time Complexity: O(n^2)
        Space Complexity: O(1)
        """
        n = len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                # Check if the current pair sums to the target
                if nums[i] + nums[j] == target:
                    return [i, j]

# Approach 2: Optimized with Hash Map
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        Optimized approach using a hash map:
        Store each number's index as we iterate, and check if the complement exists.
        Time Complexity: O(n)
        Space Complexity: O(n)
        """
        seen = {}  # Dictionary to store number -> index
        for i, num in enumerate(nums):
            complement = target - num
            # If complement is already seen, return its index and current index
            if complement in seen:
                return [seen[complement], i]
            # Otherwise, store the current number with its index
            seen[num] = i
