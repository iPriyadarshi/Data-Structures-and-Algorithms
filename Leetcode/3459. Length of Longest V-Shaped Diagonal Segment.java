// Approach 1: Without memoization
/*
Time Complexity: O(m * n * 4 * 2^L), where:
- m * n is the size of the grid
- 4 is the number of possible directions
- 2^L is because at each step we have 2 choices (continue straight or turn) 
    and L is the maximum possible length of a V-shaped diagonal

Space Complexity: O(L) where L is the maximum possible length of a V-shaped diagonal
due to recursion stack depth
*/
class Solution {
    int[][] directions = {
            { 1, 1 }, // TL-BR
            { 1, -1 }, // TR-BL
            { -1, -1 }, // BR-TL
            { -1, 1 } // BL-TR
    };

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        result = Math.max(result, 1 + solve(i, j, true, 2, d, grid));
                    }
                }
            }
        }
        return result;
    }

    private int solve(int row, int col, boolean canTurn, int expected, int dir, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxLen = 0;

        // Move in current direction
        int newRow = row + directions[dir][0];
        int newCol = col + directions[dir][1];

        if (isValid(newRow, newCol, m, n) && grid[newRow][newCol] == expected) {
            maxLen = Math.max(maxLen, 1 + solve(newRow, newCol, canTurn, next(expected), dir, grid));
        }

        // Try turning clockwise if allowed
        if (canTurn) {
            int newDir = (dir + 1) % 4;
            int turnRow = row + directions[newDir][0];
            int turnCol = col + directions[newDir][1];

            if (isValid(turnRow, turnCol, m, n) && grid[turnRow][turnCol] == expected) {
                maxLen = Math.max(maxLen, 1 + solve(turnRow, turnCol, false, next(expected), newDir, grid));
            }
        }

        return maxLen;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private int next(int val) {
        return val == 2 ? 0 : 2;
    }
}

// Approach 2: With memoization
/*
 * Time Complexity: O(m * n * 4 * 2), where:
 * - m * n is the size of the grid
 * - 4 is the number of possible directions
 * - 2 is for the canTurn states (true/false)
 * Each state is computed only once and stored in memo.
 * 
 * Space Complexity: O(m * n * 4 * 2), where:
 * - m * n * 4 * 2 is the size of the memoization array
 * - Plus O(L) for recursion stack depth where L is the maximum path length
 */
class Solution {
    int[][] directions = {
            { 1, 1 }, // 0: TL-BR
            { 1, -1 }, // 1: TR-BL
            { -1, -1 }, // 2: BR-TL
            { -1, 1 } // 3: BL-TR
    };

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        // Memoization: [row][col][dir][canTurn]
        Integer[][][][] memo = new Integer[m][n][4][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        result = Math.max(result, 1 + dfs(i, j, d, true, 0, grid, memo));
                    }
                }
            }
        }
        return result;
    }

    private int dfs(int row, int col, int dir, boolean canTurn, int depth, int[][] grid, Integer[][][][] memo) {
        int m = grid.length, n = grid[0].length;
        int turnFlag = canTurn ? 1 : 0;

        if (memo[row][col][dir][turnFlag] != null) {
            return memo[row][col][dir][turnFlag];
        }

        int expected = (depth % 2 == 0) ? 2 : 0;
        int maxLen = 0;

        // Move in current direction
        int newRow = row + directions[dir][0];
        int newCol = col + directions[dir][1];

        if (isValid(newRow, newCol, m, n) && grid[newRow][newCol] == expected) {
            maxLen = Math.max(maxLen, 1 + dfs(newRow, newCol, dir, canTurn, depth + 1, grid, memo));
        }

        // Try one clockwise turn if allowed
        if (canTurn) {
            int newDir = (dir + 1) % 4;
            int turnRow = row + directions[newDir][0];
            int turnCol = col + directions[newDir][1];

            if (isValid(turnRow, turnCol, m, n) && grid[turnRow][turnCol] == expected) {
                maxLen = Math.max(maxLen, 1 + dfs(turnRow, turnCol, newDir, false, depth + 1, grid, memo));
            }
        }

        memo[row][col][dir][turnFlag] = maxLen;
        return maxLen;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}