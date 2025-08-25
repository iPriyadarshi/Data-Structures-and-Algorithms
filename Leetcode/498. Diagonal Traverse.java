import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        /**
         * Time Complexity: O(M * N) where M is number of rows and N is number of
         * columns
         * - We visit each element in the matrix exactly once
         * - Collections.reverse() takes O(K) time where K is the length of diagonal
         * 
         * Space Complexity: O(min(M,N))
         * - The 'intermediate' list stores elements of one diagonal at a time
         * - The maximum length of a diagonal is min(M,N)
         * - The result array is not counted in auxiliary space complexity
         */
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;

        // Loop through each diagonal (total m + n - 1 diagonals)
        for (int d = 0; d < m + n - 1; d++) {
            List<Integer> intermediate = new ArrayList<>();

            // Determine the starting point of the diagonal
            int row, col;
            if (d < n) {
                // Diagonal starts from the top row
                row = 0;
                col = d;
            } else {
                // Diagonal starts from the last column
                col = n - 1;
                row = d - (n - 1);
            }

            // Collect all elements in the current diagonal
            while (row < m && col >= 0) {
                intermediate.add(mat[row][col]);
                row++;
                col--;
            }

            // Explanation:
            // The 'intermediate' list temporarily stores all elements of the current
            // diagonal.
            // This is necessary because we may need to reverse the order depending on the
            // diagonal index.
            // For even-numbered diagonals, we reverse the list before adding to the final
            // result.

            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            // Add the processed diagonal to the result array
            for (int val : intermediate) {
                result[index++] = val;
            }
        }
        return result;
    }
}