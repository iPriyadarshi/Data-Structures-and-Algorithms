import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    // Time Complexity: O(N!) - In the worst case, we might have to explore all possible arrangements of N queens on the board.
    // Space Complexity: O(N) - We are using additional space for the board and the sets to track columns and diagonals.
    // The recursion stack can go as deep as N levels.
    private int result = 0;

    public int totalNQueens(int n) {

        if (n == 0)
            return result;

        List<String> board = new ArrayList<>();
        // create board
        // For, n = 3, board = {"...", "...", "..."} initially
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row.toString());
        }

        int startRow = 0;
        // Maintain 3 sets to check validity of a cell
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> diags = new HashSet<>();
        HashSet<Integer> antiDiags = new HashSet<>();
        solve(board, startRow, cols, diags, antiDiags);

        return result;
    }

    private void solve(List<String> board, int row, HashSet<Integer> cols, HashSet<Integer> diags,
            HashSet<Integer> antiDiags) {
        if (row == board.size()) {
            result += 1;
            return;
        }

        // For a square (i, j) : Diagonally (i-j) is constant and Anti diagonally (i+j) is constant
        // We can use this to find which square (i, j) has a risk of being attacked by another queen placed already in 'diagonal', or 'anti-diagonal' or 'column'

        for (int col = 0; col < board.size(); col++) {
            int diagId = row - col;
            int antiDiagId = row + col;

            // If the col, or diagonal or anti_diagonal are used means one of them has a Queen placed already which can attack, so look for other column

            if (cols.contains(col) || diags.contains(diagId) || antiDiags.contains(antiDiagId))
                continue;

            cols.add(col);
            diags.add(diagId);
            antiDiags.add(antiDiagId);
            StringBuilder newRow = new StringBuilder(board.get(row));
            newRow.setCharAt(col, 'Q');
            board.set(row, newRow.toString());

            solve(board, row + 1, cols, diags, antiDiags);

            cols.remove(col);
            diags.remove(diagId);
            antiDiags.remove(antiDiagId);
            newRow.setCharAt(col, '.');
            board.set(row, newRow.toString());
        }
    }
}