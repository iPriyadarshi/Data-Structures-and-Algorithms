from typing import List


class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        """
        Time Complexity: O(n^2) - Using nested loops to compare each number with every other number
        Space Complexity: O(n) - Using additional array 'result' to store counts, where n is length of input array
        """
        n = len(nums)
        result = []
        for i in range(n):
            count = 0
            for j in range(n):
                if nums[j] < nums[i]:
                    count += 1
            result.append(count)
        return result