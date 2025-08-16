from typing import List


class Solution:
    """
    Time Complexity: O(log n) - where n is the length of nums
    Space Complexity: O(1) - constant extra space used
    """

    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        return -1
