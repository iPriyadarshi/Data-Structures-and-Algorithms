from typing import List


# Approach 1: Using HashTable
class Solution:
    """
    Time Complexity: O(n) where n is length of nums array
    Space Complexity: O(n) where n is length of nums array to store the hashtable
    """

    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        hashtable = {}
        for i in range(len(nums)):
            num = nums[i]
            if num in hashtable and i - hashtable[num] <= k:
                return True
            hashtable[num] = i
        return False


# Approach 2: Using Sliding Window
class Solution:
    """
    Time Complexity: O(n) where n is the length of nums
    Space Complexity: O(min(k, n)) to store the sliding window set
    """

    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        num_set = set()
        for i in range(len(nums)):
            if i > k:
                num_set.remove(nums[i - k - 1])
            if nums[i] in num_set:
                return True
            num_set.add(nums[i])
        return False
