from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_to_index = {}
        for index, num in enumerate(nums):
            difference = target - num
            if difference in num_to_index:
                return [num_to_index[difference], index]
            num_to_index[num] = index
