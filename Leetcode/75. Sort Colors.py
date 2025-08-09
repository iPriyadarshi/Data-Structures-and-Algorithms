from typing import List

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        i = 0  # denotes for 0
        j = 0  # denotes for 1
        k = n - 1  # denotes for 2
        while j <= k:
            if nums[j] == 1:
                j += 1
            elif nums[j] == 2:
                nums[j], nums[k] = nums[k], nums[j]
                k -= 1
            else:  # nums[j]==0
                nums[j], nums[i] = nums[i], nums[j]
                i += 1
                j += 1
