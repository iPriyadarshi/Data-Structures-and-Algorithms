from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        # Time Complexity: O(n^2), where n is numRows
        # - We have to iterate through each row (n iterations)
        # - For each row, we fill in O(row_num) elements
        
        # Space Complexity: O(n^2)
        # - We store a triangle with n rows, where row i has (i+1) elements
        # - Total elements stored = 1 + 2 + 3 + ... + n = n(n+1)/2 which is O(n^2)
        
        triangle = []

        for row_num in range(numRows):
            # Start each row with 1s
            row = [1] * (row_num + 1)

            # Fill in the middle values
            for j in range(1, row_num):
                row[j] = triangle[row_num - 1][j - 1] + triangle[row_num - 1][j]

            triangle.append(row)

        return triangle