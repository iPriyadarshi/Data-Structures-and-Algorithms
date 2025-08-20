from typing import List


class Solution:
    """
    Given an integer array nums, finds the index of the largest element that is at least twice as large as any other element.
    The largest element in nums is unique.

    Args:
        nums (List[int]): Array of integers

    Returns:
        int: Index of the largest element if it is at least twice as large as every other element,
             -1 if no such element exists

    Time Complexity: O(n) where n is the length of nums array
    Space Complexity: O(1) as only constant extra space is used
    """

    def dominantIndex(self, nums: List[int]) -> int:
        n = len(nums)
        maxIndex = 0
        for i in range(n):
            if nums[i] > nums[maxIndex]:
                maxIndex = i
        for i in range(n):
            if nums[i] != nums[maxIndex] and nums[maxIndex] < 2 * nums[i]:
                return -1
        return maxIndex
