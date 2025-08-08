from typing import List

class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        n = len(nums)
        answer = []
        leftSum = []
        rightSum = []
        left = 0
        total = sum(nums)
        for i in range(n):
            leftSum.append(left)
            left += nums[i]
            right = total - left
            rightSum.append(right)
        for i in range(n):
            answer.append(abs(leftSum[i] - rightSum[i]))
        return answer
