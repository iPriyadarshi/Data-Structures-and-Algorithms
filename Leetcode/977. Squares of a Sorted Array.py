from typing import List


# Approach 1:
# Time Complexity: O(n log n) due to sorting
# Space Complexity: O(n) for the result array
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0 for _ in range(n)]
        for i in range(n):
            result[i] = nums[i] * nums[i]

        result.sort()
        return result


# Approach 2:
# Time Complexity: O(n) - single pass through the array
# Space Complexity: O(n) for the result array
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0] * n  # Pre-allocate space
        i, j = 0, n - 1
        pos = n - 1  # Start filling from the end

        while i <= j:
            left_sq = nums[i] ** 2
            right_sq = nums[j] ** 2

            if left_sq > right_sq:
                result[pos] = left_sq
                i += 1
            else:
                result[pos] = right_sq
                j -= 1

            pos -= 1

        return result
