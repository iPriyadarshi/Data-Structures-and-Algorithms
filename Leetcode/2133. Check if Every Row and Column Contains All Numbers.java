import java.util.HashSet;
import java.util.Set;

/**
 * Validates if a square matrix contains all numbers from 1 to n in each row and column,
 * where n is the size of the matrix.
 * 
 * The method performs two checks:
 * 1. Verifies each row contains unique numbers from 1 to n
 * 2. Verifies each column contains unique numbers from 1 to n
 * 
 * @param matrix A square matrix (n x n) containing integers
 * @return true if every row and column contains all numbers from 1 to n exactly once,
 *         false otherwise
 * 
 * Time Complexity: O(n²) where n is the size of the matrix
 * Space Complexity: O(n) for the HashSet storing elements of each row/column
 */
class Solution {
    public boolean checkValid(int[][] matrix) {
        Set<Integer> set = null;
        // Check for every rows
        for (int i = 0; i < matrix.length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                int ele = matrix[i][j];
                if (set.contains(ele)) {
                    return false;
                } else {
                    set.add(ele);
                }
            }
        }
        // Check for every columns
        for (int i = 0; i < matrix[0].length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                int ele = matrix[j][i];
                if (set.contains(ele)) {
                    return false;
                } else {
                    set.add(ele);
                }
            }
        }
        return true;
    }
}