class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        """
        :type candies: List[int]
        :type extraCandies: int
        :rtype: List[bool]
        
        Time Complexity: O(n) where n is the length of candies list
        - max() operation takes O(n)
        - list comprehension iterates through all elements once, O(n)
        
        Space Complexity: O(n)
        - Creates a new boolean list of the same length as input
        """
        max_candies = max(candies)
        return [candy + extraCandies >= max_candies for candy in candies]