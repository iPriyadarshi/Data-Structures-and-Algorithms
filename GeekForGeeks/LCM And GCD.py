# https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/0

from typing import List


class Solution:
    def find_gcd(self, a, b):
        # Time Complexity: O(log min(a,b)) - Euclidean algorithm
        # Space Complexity: O(1)
        while b != 0:
            a, b = b, a % b
        return a

    def lcmAndGcd(self, a: int, b: int) -> List[int]:
        # Time Complexity: O(log min(a,b))
        # Space Complexity: O(1) - result list is part of output
        result = []

        gcd = self.find_gcd(a, b)
        lcm = (a * b) // gcd
        result.append(lcm)
        result.append(gcd)
        return result
