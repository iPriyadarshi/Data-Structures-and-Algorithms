// Approach (Backtracking template and all possible options)

/**
 * Uses backtracking algorithm to fill the 9x9 grid with numbers from 1-9.
 *
 * Time Complexity: O(9^(n*n)) where n is the size of the grid (9 in standard
 * Sudoku)
 * - For each empty cell, we try 9 possibilities
 * - In worst case, we need to try all possibilities for each empty cell
 *
 * Space Complexity: O(n*n) where n is the size of the grid
 * - The recursion can go up to the number of empty cells in the grid (81 in
 * worst case)
 * - Each recursive call uses constant extra space
 *
 */
class Solution {
    // T.C : O(9^81) = O(1), fixed grid size
    // S.C : O(81) = O(1), fixed grid size
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValid(board, i, j, d)) {
                            board[i][j] = d;

                            if (solve(board)) {
                                return true;
                            }

                            board[i][j] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // sudoku solved
    }

    private boolean isValid(char[][] board, int row, int col, char d) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == d)
                return false; // check column
            if (board[row][i] == d)
                return false; // check row
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[startRow + k][startCol + l] == d) {
                    return false; // check 3x3 box
                }
            }
        }
        return true;
    }
}