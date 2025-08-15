from typing import List


class Solution:
    """
    Time Complexity: O(n) where n is length of nums array
    Space Complexity: O(min(n,k)) to store the sliding window hashtable
    """

    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        hashtable = {}
        for i in range(len(nums)):
            num = nums[i]
            if num in hashtable and i - hashtable[num] <= k:
                return True
            hashtable[num] = i
        return False
