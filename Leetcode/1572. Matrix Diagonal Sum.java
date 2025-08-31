/**
 * Calculates the sum of elements on both main diagonal and secondary diagonal of a square matrix.
 * For elements that belong to both diagonals (when matrix size is odd), they are counted only once.
 *
 * Time Complexity: O(n²) where n is the length of matrix
 * Space Complexity: O(1) as only a constant amount of extra space is used
 *
 * @param mat input square matrix (n x n)
 * @return sum of all elements on both diagonals
 */
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    result += mat[i][j];
                }
            }
        }
        return result;
    }
}