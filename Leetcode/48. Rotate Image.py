from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        
        Time Complexity: O(n^2) where n is the length of the matrix
        - We traverse the matrix twice: once for transpose and once for reversing rows
        
        Space Complexity: O(1)
        - We modify the matrix in-place without using extra space
        """
        n = len(matrix)

        # Transpose the matrix
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        # Reverse each row
        for i in range(n):
            matrix[i].reverse()


# Tip: To rotate
# 90 degree = transpose + reverse row
# 180 degree = reverse row + reverse column
# 270 degree = transpose + reverse column