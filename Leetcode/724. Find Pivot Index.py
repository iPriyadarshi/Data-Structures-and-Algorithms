from typing import List


class Solution:
    """
    Find the pivot index in an array. The pivot index is the index where the sum of all numbers to its left equals the sum of all numbers to its right.

    Time Complexity: O(n) where n is length of input array. One pass to calculate total sum and one pass to find pivot
    Space Complexity: O(1) as we only use a few variables regardless of input size

    """
    def pivotIndex(self, nums: List[int]) -> int:
        total_sum = sum(nums)
        left_sum = 0

        for i in range(len(nums)):
            right_sum = total_sum - left_sum - nums[i]
            if left_sum == right_sum:
                return i
            left_sum += nums[i]

        return -1