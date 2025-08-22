class Solution {
    /**
     * Time Complexity: O(m*n) where m is number of rows and n is number of columns
     * - We need to traverse through each cell of the grid once
     * 
     * Space Complexity: O(1)
     * - We only use a constant amount of extra space to store variables
     */
    public int minimumArea(int[][] grid) {
        int m = grid.length; // Rows
        int n = grid[0].length; // Columns

        int minRow = m;
        int maxRow = -1;
        int minCol = n;
        int maxCol = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);

                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        int length = maxCol - minCol + 1;
        int width = maxRow - minRow + 1;
        return length * width;
    }
}