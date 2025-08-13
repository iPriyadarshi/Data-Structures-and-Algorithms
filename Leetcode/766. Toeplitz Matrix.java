/**
 * Determines if a given matrix is a Toeplitz matrix.
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 * Time Complexity: O(m*n), where m is number of rows and n is number of columns
 * Space Complexity: O(1), only uses constant extra space
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }
        return true;
    }
}