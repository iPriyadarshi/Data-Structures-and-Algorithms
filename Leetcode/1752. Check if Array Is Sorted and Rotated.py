from typing import List
# Approach1: Brute Force Approach
class Solution:
    def check(self, nums: List[int]) -> bool:
        n = len(nums)
        for r in range(n):
            # Rotate the array at index r
            rotated = nums[r:] + nums[:r]
            
            # Check if the rotated array is sorted
            isSorted = True
            for i in range(n - 1):
                if rotated[i] > rotated[i + 1]:
                    isSorted = False
                    break
            
            if isSorted:
                return True
        
        return False

# Approach2: Optimized Approach
class Solution:
    def check(self, nums: List[int]) -> bool:
        n = len(nums)
        count = 0
        for i in range(n):
            if nums[i] > nums[(i + 1) % n]:
                count += 1
        return count <= 1