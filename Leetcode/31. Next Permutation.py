from typing import List


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Finds the next lexicographically greater permutation of nums in-place.
        
        Time Complexity: O(n) where n is the length of nums
        - We traverse the array twice in worst case: once to find gola_index and once to find swap_index
        - Reversing the remaining subarray takes O(n) in worst case
        
        Space Complexity: O(1) 
        - We only use a constant amount of extra space regardless of input size
        - The modification is done in-place
        
        Algorithm:
        1. Find the first pair from right where nums[i] > nums[i-1]
        2. Find the smallest number greater than nums[gola_index] in the right subarray
        3. Swap these numbers
        4. Reverse the subarray to the right of gola_index
        """
        n = len(nums)
        # Step 1: Find the first decreasing element from right (gola_index)
        gola_index = -1
        for i in range(n - 1, 0, -1):
            if nums[i] > nums[i - 1]:
                gola_index = i - 1
                break
                
        if gola_index != -1:
            # Step 2: Find the smallest number greater than nums[gola_index] in right subarray
            swap_index = gola_index
            for j in range(n - 1, gola_index, -1):
                if nums[j] > nums[gola_index]:
                    swap_index = j
                    break
                    
            # Step 3: Swap the numbers
            nums[gola_index], nums[swap_index] = nums[swap_index], nums[gola_index]
            
        # Step 4: Reverse all digits after gola_index to get smallest permutation
        nums[gola_index + 1:] = reversed(nums[gola_index + 1:])
