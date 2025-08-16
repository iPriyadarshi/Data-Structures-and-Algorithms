from typing import List


class Solution:
    """
    Time Complexity: O(n) where n is the length of input array
    Space Complexity: O(1) excluding the output array
    """
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        answer = [1] * length
        
        prefix = 1
        for i in range(length):
            answer[i] = prefix
            prefix *= nums[i]
        
        suffix = 1
        for i in range(length - 1, -1, -1):
            answer[i] *= suffix
            suffix *= nums[i]
            
        return answer