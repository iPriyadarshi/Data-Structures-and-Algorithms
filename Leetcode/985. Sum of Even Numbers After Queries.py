from typing import List

# Approach1: BruteForce - Time Limit Exceeds on Leetcode
# Time Complexity: O(m*n) where m is length of queries and n is length of nums
# - For each query, we scan entire nums array to calculate sum of even numbers
# - sum_of_even function takes O(n) time and is called m times
# Space Complexity: O(1) excluding the output array
# - We only use constant extra space for variables
# - answer array is required for output, so not counted in space complexity


class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        answer = []

        def sum_of_even(arr):
            summ = 0
            for num in arr:
                if num % 2 == 0:
                    summ += num
            return summ

        for query in queries:
            val, index = query
            nums[index] = nums[index] + val
            summation = sum_of_even(nums)
            answer.append(summation)

        return answer


# Approach2: Optimized
# Time Complexity: O(n + m) where m is length of queries and n is length of nums
# - Initial calculation of even_sum takes O(n)
# - For each query, we only do constant time operations O(1), done m times
# Space Complexity: O(1) excluding the output array
# - We only use constant extra space for variables
# - answer array is required for output, so not counted in space complexity


class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        answer = []
        even_sum = sum(num for num in nums if num % 2 == 0)

        for val, index in queries:
            if nums[index] % 2 == 0:
                even_sum -= nums[index]
            nums[index] += val
            if nums[index] % 2 == 0:
                even_sum += nums[index]
            answer.append(even_sum)
        return answer
