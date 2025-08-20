from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Time Complexity: O(n) - we traverse the array twice
        # Space Complexity: O(1) - we modify the input array in-place and only use constant extra space
        
        # Mark each number seen by negating the value at its corresponding index
        # For example, if we see number 4, we make the value at index 3 negative
        for num in nums:
            index = abs(num) - 1
            if nums[index] > 0:
                nums[index] = -nums[index]
        
        # Collect indices that have positive values — these are the missing numbers
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        
        return result