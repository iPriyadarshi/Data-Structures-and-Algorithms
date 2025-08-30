// ================================================ Approach 1: Brute Force ==================================================
/*
Time Complexity: O(9²) = O(1)
- We traverse the 9x9 board once for rows, once for columns, and once for sub-boxes
- Each traversal is O(81) operations which simplifies to O(1) since the input size is fixed

Space Complexity: O(9) = O(1)
- We use a HashSet that can store at most 9 elements at any time
- Space is constant since the input size is fixed
*/


import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Validate rows
        for (int row = 0; row < 9; row++) {
            HashSet<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);
            }
        }

        // Validate columns
        for (int col = 0; col < 9; col++) {
            HashSet<Character> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);
            }
        }

        // Validate each 3×3 sub-box
        for (int sr = 0; sr < 9; sr += 3) {
            for (int sc = 0; sc < 9; sc += 3) {
                if (!isValidSubBox(board, sr, sc))
                    return false;
            }
        }

        return true;
    }

    private boolean isValidSubBox(char[][] board, int startRow, int startCol) {
        HashSet<Character> set = new HashSet<>();
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);
            }
        }
        return true;
    }
}

// ==================================================== Approach 2: Hashing ===========================================
/*
Time Complexity: O(9²) = O(1)
- We traverse the 9x9 board once
- For each cell, we perform constant time operations (HashSet operations)
- Since the board size is fixed, this simplifies to O(1)

Space Complexity: O(9²) = O(1)
- In worst case, we store 3 strings for each non-empty cell
- Maximum size of HashSet would be 9 * 9 * 3 = 243 entries
- Since the board size is fixed, this simplifies to O(1)
*/


// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         HashSet<String> seen = new HashSet<>();

//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 char current = board[i][j];
//                 if (current == '.') continue;

//                 String rowKey = current + "_row_" + i;
//                 String colKey = current + "_col_" + j;
//                 String boxKey = current + "_box_" + (i / 3) + "_" + (j / 3);

//                 if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
//                     return false;
//                 }

//                 seen.add(rowKey);
//                 seen.add(colKey);
//                 seen.add(boxKey);
//             }
//         }

//         return true;
//     }
// }
