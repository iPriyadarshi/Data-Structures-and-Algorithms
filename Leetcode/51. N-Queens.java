import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// ========================================= Approach-1 (Simple dfs) =========================================

// T.C : O(N!)
// S.C : O(N) to store the result

// class Solution {
//     private List<List<String>> result = new ArrayList<>();

//     public List<List<String>> solveNQueens(int n) {
//         if (n == 0)
//             return result;
//         // create board
//         // For n = 3, board = {"...", "...", "..."} initially
//         List<String> board = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             StringBuilder row = new StringBuilder();
//             for (int j = 0; j < n; j++) {
//                 row.append('.');
//             }
//             board.add(row.toString());
//         }

//         solve(board, 0);

//         return result;
//     }

//     private boolean isValid(List<String> board, int row, int col) {
//         // Look for up
//         for (int i = row; i >= 0; i--) {
//             if (board.get(i).charAt(col) == 'Q')
//                 return false;
//         }

//         // Check left diagonal upwards
//         for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
//             if (board.get(i).charAt(j) == 'Q')
//                 return false;
//         }

//         // Check right diagonal upwards
//         for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
//             if (board.get(i).charAt(j) == 'Q')
//                 return false;
//         }

//         return true;    // selected place is valid
//     }

//     private void solve(List<String> board, int row) {
//         if (row == board.size()) {
//             result.add(new ArrayList<>(board));
//             return;
//         }

//         for (int i = 0; i < board.size(); i++) {
//             if (isValid(board, row, i)) {
//                 StringBuilder newRow = new StringBuilder(board.get(row));
//                 newRow.setCharAt(i, 'Q');
//                 board.set(row, newRow.toString()); // do

//                 solve(board, row + 1); // explore

//                 newRow.setCharAt(i, '.');
//                 board.set(row, newRow.toString()); // undo
//             }
//         }
//     }
// }

// =================================== Approach-2: Optimized ===============================================

// T.C : O(N!) in worst case it explores all possible configurations
// S.C : O(N) for result and also for storing, cols, diags and antiDiags

class Solution {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
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
            result.add(new ArrayList<>(board));
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
