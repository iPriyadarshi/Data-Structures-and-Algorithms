/**
 * Returns a list of all elements in the matrix in spiral order.
 * Traverses the matrix in a clockwise spiral pattern starting from the top-left corner.
 * 
 * The traversal follows this pattern:
 * 1. Left to right along the top row
 * 2. Top to bottom along the right column
 * 3. Right to left along the bottom row
 * 4. Bottom to top along the left column
 * 
 * Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
 * Space Complexity: O(1) excluding the space used for output
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        int dir = 0;

        while (top <= bottom && left <= right) {
            if (dir == 0) {
                // left to right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) {
                // top to bottom
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                // right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            } else if (dir == 3) {
                // bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }

        return result;
    }
}