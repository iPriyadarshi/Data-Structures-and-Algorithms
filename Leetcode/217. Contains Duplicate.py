from typing import List


class Solution:
    """
    Time Complexity: O(n log n) - due to sorting operation
    Space Complexity: O(1) - in-place sorting, no extra space needed
    """

    def containsDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        for i in range(len(nums) - 1):
            if nums[i] == nums[i + 1]:
                return True
        return False
