from typing import List

class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        # creating freq map for both basket arr  # finding extra_count
        freq_map = {}
        for i in basket1:
            if i not in freq_map:
                freq_map[i] = 1
            else:
                freq_map[i] += 1
        for i in basket2:
            if i not in freq_map:
                freq_map[i] = -1
            else:
                freq_map[i] -= 1

        # finding the minimum element among all elements of both arrays
        min_1 = min(basket1)
        min_2 = min(basket2)
        global_min = min(min_1, min_2)
        
        # Check if the sum of frequencies of an element in both arrays is odd, if so return -1
        for val in freq_map.values():
            if val % 2 != 0:
        # Store the elements that need to be swapped in a list, and sort it.

        # Store the elements that need to be swapped in a vector, and sort it.
        extra1 = []
        extra2 = []
        for key, val in freq_map.items():
            if val > 0:
                extra1.extend([key] * (val // 2))
            elif val < 0:
                extra2.extend([key] * (-val // 2))
        extra1.sort()
        extra2.sort(reverse=True)

        # Can we reduce swapping cost with the help of minimum element?
        # yes

        # Calculate the minimum cost of swapping.
        cost = 0
        for x, y in zip(extra1, extra2):
            cost += min(2 * global_min, min(x, y))

        return cost
