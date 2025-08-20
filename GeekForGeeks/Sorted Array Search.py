# https://www.geeksforgeeks.org/problems/who-will-win-1587115621/0


class Solution:
    """
    A solution class that implements binary search on a sorted array.

    This class provides a method to search for a specific element in a sorted array
    using the binary search algorithm.

    Methods:
        searchInSorted(arr, k): Searches for element k in sorted array arr
            Args:
                arr (List[int]): A sorted array of integers
                k (int): The target value to search for

            Returns:
                bool: True if k is found in arr, False otherwise

            Time Complexity: O(log n) where n is length of array
            Space Complexity: O(1)
    """

    def searchInSorted(self, arr, k):
        # Your code here
        left = 0
        right = len(arr) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if k == arr[mid]:
                return True
            elif k < arr[mid]:
                right = mid - 1
            else:
                left = mid + 1
        return False
