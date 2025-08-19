from typing import List


class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        # Time Complexity: O(nlogn) due to sorting
        # Space Complexity: O(1) as we only use constant extra space
        nums.sort()
        n = len(nums)
        result = 0
        for i in range(0, n, 2):
            result += nums[i]
        return result


# 1. We choose two numbers to make a pair.
# 2. Then we take min(a,b) = val
# 3. This sum of val's has to be maximum.

# So, in all the pairs we make , if we take a bigger number and a very small number and take min of these two numbers then we are just wasting away the bigger number as it could be used with some other number for pairing so that it will contribute to the final sum.

# So, when we do sorting , we make the adjacent numbers numerically close to each others. So, we can take pairwise elements like 1st and 2nd elements, 3rd and 4th element.. etc so reduce the difference between two numbers in each pair.

# example:

# input = [1, 1000, 3, 999]

# Then if we take (1,1000) and (3,999) as pairs :

# min1 = min(1,1000) = 1
# min2 = min(3,999) = 3

# Final sum = min1 + min2 = 4

# But if we sorted the array, we can choose adjacent numbers in the array as the pairs.

# then: input = [1,3,999,1000]
# min1 = min(1,3) = 1
# min2 = min(999,1000) = 999

# final sum = min1 + min2 = 1000

# We can clearly observe how we get the difference and that's why sorting of array is needed here.
