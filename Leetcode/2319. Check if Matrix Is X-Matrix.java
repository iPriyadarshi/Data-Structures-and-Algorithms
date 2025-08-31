/**
 * Checks if a given square matrix is an X-Matrix.
 * An X-Matrix is a square matrix of size n x n where:
 * 1. All elements on the main diagonal and anti-diagonal are non-zero
 * 2. All other elements are 0
 * 
 * @param grid The input square matrix to be checked
 * @return true if the matrix is an X-Matrix, false otherwise
 * 
 * Time Complexity: O(n²) where n is the size of the square matrix
 * Space Complexity: O(1) as only constant extra space is used
 */
class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j) || (i + j == n - 1)) {
                    if (grid[i][j] == 0) return false;
                } else {
                    if (grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }
}