# https://www.geeksforgeeks.org/problems/reverse-an-array/1

class Solution:
    def reverseArray(self, arr):
        # Time Complexity: O(n/2) = O(n) where n is length of array
        # Space Complexity: O(1) as we are modifying array in-place
        left = 0
        right = len(arr) - 1
        while left < right:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -= 1
        return arr