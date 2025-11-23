import java.util.Arrays;

// Recursion
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return solve(text1, text2, 0, 0);
    }

    private int solve(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + solve(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(solve(text1, text2, i + 1, j), solve(text1, text2, i, j + 1));
        }
    }
}

// Memoization
class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        // Initialize with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(text1, text2, 0, 0, dp);
    }

    private int solve(String text1, String text2, int i, int j, int[][] dp) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + solve(text1, text2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(
                    solve(text1, text2, i + 1, j, dp),
                    solve(text1, text2, i, j + 1, dp));
        }
    }
}

// Bottom-Up DP
class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int row = 0; row <= m; row++) {
            dp[row][0] = 0;
        }
        for (int col = 0; col <= n; col++) {
            dp[0][col] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}