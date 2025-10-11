from typing import List


class Solution:
    def projectionArea(self, grid: List[List[int]]) -> int:
        # T.C = O(N^2), N = len(grid)
        # S.C = O(1)
        n = len(grid)

        top_area = 0  # xy-plane: count all non-zero cells
        for i in range(n):
            for j in range(n):
                area = 1 if grid[i][j] != 0 else 0
                top_area += area

        front_area = 0  # xz-plane: max in each row
        for i in range(n):
            max_in_row = 0
            for j in range(n):
                max_in_row = max(max_in_row, grid[i][j])
            front_area += max_in_row

        side_area = 0  # yz-plane: max in each column
        for i in range(n):
            max_in_col = 0
            for j in range(n):
                max_in_col = max(max_in_col, grid[j][i])
            side_area += max_in_col

        return top_area + front_area + side_area
