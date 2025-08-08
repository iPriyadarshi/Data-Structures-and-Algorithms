from typing import List

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        n = len(numbers)
        left = 0
        right = n - 1
        while left <= right:
            sum_of_two = numbers[left] + numbers[right]
            if sum_of_two < target:
                left += 1
            elif sum_of_two > target:
                right -= 1
            else:
                return [left + 1, right + 1]
