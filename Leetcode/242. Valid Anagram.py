class Solution:
    """
    Time complexity: O(n log n) where n is the length of the strings
    Space complexity: O(n) - Python's sorting algorithm creates new sorted lists, using O(n) extra space
    """
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
            
        return sorted(s) == sorted(t)

        