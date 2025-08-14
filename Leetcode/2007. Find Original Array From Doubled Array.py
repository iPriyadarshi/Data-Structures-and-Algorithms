from typing import List


class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        """
        Time Complexity: O(n log n), where n is the length of the input array
        - Sorting the array takes O(n log n)
        - Creating frequency map takes O(n)
        - Final iteration through the array takes O(n)

        Space Complexity: O(n)
        - freq_map dictionary stores up to n elements
        - result array stores n/2 elements
        - Python's built-in sort uses O(n) space
        """
        n = len(changed)
        result = []

        # If the length of the array is odd, it's impossible to form pairs (x, 2x)
        if n % 2 != 0:
            return []

        # Sort the array to ensure we process smaller numbers first.
        # This is crucial because we want to match each number with its double,
        # and sorting helps avoid mismatches (e.g., matching 4 with 2 instead of 2 with 4).
        changed.sort()

        # Create a frequency map to count occurrences of each number
        freq_map = {}
        for i in changed:
            if i not in freq_map:
                freq_map[i] = 0
            freq_map[i] += 1

        # Iterate through the sorted array
        for num in changed:
            # If the current number has already been used in a pair, skip it
            if freq_map[num] == 0:
                continue

            twice = 2 * num  # The number we need to pair with

            # If the double isn't available or already used up, the array is invalid
            if twice not in freq_map or freq_map[twice] == 0:
                return []

            # Append the original number to the result
            result.append(num)

            # Decrement the frequency of both the number and its double
            freq_map[num] -= 1
            freq_map[twice] -= 1

        return result
