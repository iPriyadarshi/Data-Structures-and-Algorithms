from typing import List

class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        """
        Time Complexity: O(m*n) where m is number of rows and n is number of columns
        - We traverse each element once to create the map
        - We traverse each element again while creating the result

        Space Complexity: O(m*n) 
        - We store all elements in the ipj_map dictionary
        - We store all elements in the result list
        """
        m = len(mat)
        n = len(mat[0])

        ipj_map = {}
        result = []

        # Fill map using [i + j] as key
        for i in range(m):
            for j in range(n):
                if (i + j) not in ipj_map:
                    ipj_map[i + j] = []
                ipj_map[i + j].append(mat[i][j])

        # Traverse diagonals in zigzag order
        for key in range(m + n - 1):
            values = ipj_map[key]
            if key % 2 == 0:
                result.extend(values[::-1])  # Reverse even diagonals
            else:
                result.extend(values)        # Keep odd diagonals as-is

        return result