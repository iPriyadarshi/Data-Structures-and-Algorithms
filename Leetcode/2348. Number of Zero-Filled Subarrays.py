from typing import List


# Approach 1: Using simple maths to calculate subarrays
class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        # Time Complexity: O(n) as we traverse the array once.
        # Space Complexity: O(1) — No extra space used beyond variables.

        result = 0
        n = len(nums)
        i = 0
        while i < n:
            subArrLen = 0
            if nums[i] == 0:
                while i < n and nums[i] == 0:
                    subArrLen += 1
                    i += 1
            else:
                i += 1
            result += (subArrLen * (subArrLen + 1)) // 2
        return result


# Approach 2: Using Observation
class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        # Time Complexity: O(n) as we traverse the array once.
        # Space Complexity: O(1) — No extra space used beyond variables.

        result = 0
        n = len(nums)
        contiguousZeroCount = 0
        for i in range(n):
            if nums[i] == 0:
                contiguousZeroCount += 1
            else:
                contiguousZeroCount = 0
            result += contiguousZeroCount
        return result
