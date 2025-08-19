class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        Find the length of the longest substring without repeating characters.
        Uses sliding window technique with a set to track unique characters.
        Args:
            s (str): Input string to find longest substring without repeats
        Returns:
            int: Length of the longest substring without repeating characters
        Time Complexity: O(n) where n is length of string
            - Each character is added and removed at most once
        Space Complexity: O(k) where k is size of character set
            - Set stores at most k unique characters from string
        """
        charSet = set()
        left = 0
        result = 0

        for right in range(len(s)):
            while s[right] in charSet:
                charSet.remove(s[left])
                left += 1
            charSet.add(s[right])
            result = max(result, right - left + 1)
        return result
