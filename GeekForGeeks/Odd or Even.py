# https://www.geeksforgeeks.org/problems/odd-or-even3618/0


# Approach 1:
class Solution:
    def isEven(self, n):
        """
        Determines if a given number is even using modulo operator.
        """
        return n % 2 == 0


# Approach 2:
class Solution:
    def isEven(self, n):
        """
        Determines if a given number is even using bitwise AND.
        """
        return n & 1 == 0


# Approach 3:
class Solution:
    def isEven(self, n):
        """
        Determines if a given number is even using bitwise NOT and AND.
        """
        return not (n & 1)
