from typing import List


class Solution:
    """
    Find the third maximum number in a non-empty array of integers.

    If the third maximum does not exist, return the maximum number instead.

    Note:
        - The time complexity is O(n), where n is the length of the input array.
        - The space complexity is O(1) as we only use three variables.
    """

    def thirdMax(self, nums: List[int]) -> int:
        max1 = max2 = max3 = -float("inf")
        for num in nums:
            if num in (max1, max2, max3):
                continue
            if num > max1:
                max3 = max2
                max2 = max1
                max1 = num
            elif num > max2:
                max3 = max2
                max2 = num
            elif num > max3:
                max3 = num
        return max3 if max3 != -float("inf") else max1
