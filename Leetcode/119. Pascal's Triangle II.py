from typing import List


# Approach 1: Using Factorial
class Solution:
    """
    Time Complexity: O(n^2), where n is rowIndex
    - O(n) for main loop
    - O(n) for each factorial calculation

    Space Complexity: O(n)
    - where n is rowIndex
    - Only storing the result array
    """

    def getRow(self, rowIndex: int) -> List[int]:
        result = []
        for i in range(rowIndex + 1):
            val = self.factorial(rowIndex) // (self.factorial(i) * self.factorial(rowIndex - i))
            result.append(val)
        return result

    def factorial(self, num):
        if num == 0:
            return 1
        fact = 1
        for i in range(1, num + 1):
            fact *= i
        return fact


# Approach 2: Optimized using combination property
class Solution:
    """
    Time Complexity: O(n), where n is rowIndex
    - Single pass through rowIndex
    - Each operation is O(1)

    Space Complexity: O(n)
    - where n is rowIndex
    - Only storing the result array
    """

    def getRow(self, rowIndex: int) -> List[int]:
        result = []
        val = 1
        for i in range(rowIndex + 1):
            result.append(val)
            val = val * (rowIndex - i) // (i + 1)
        return result
