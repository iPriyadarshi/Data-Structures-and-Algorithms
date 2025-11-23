import java.util.Arrays;

// Recursion
class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        return solve(0, s, n);
    }

    private int solve(int i, String s, int n) {
        if (i == n)
            return 1; // one valid split done

        if (s.charAt(i) == '0') {
            return 0; // not possible to split
        }

        int only_ith_char_taken = solve(i + 1, s, n);
        int ith_iplus1th_char_taken = 0;
        if (i + 1 < n) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                ith_iplus1th_char_taken = solve(i + 2, s, n);
            }
        }
        return only_ith_char_taken + ith_iplus1th_char_taken;
    }
}

// Memoization
class Solution2 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); // initialize with -1 (uncomputed)
        return solve(0, s, n, dp);
    }

    private int solve(int i, String s, int n, int[] dp) {
        if (i == n)
            return 1; // one valid split done

        if (s.charAt(i) == '0')
            return 0; // not possible to split

        if (dp[i] != -1) // already computed
            return dp[i];

        int only_ith_char_taken = solve(i + 1, s, n, dp);
        int ith_iplus1th_char_taken = 0;

        if (i + 1 < n) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                ith_iplus1th_char_taken = solve(i + 2, s, n, dp);
            }
        }

        dp[i] = only_ith_char_taken + ith_iplus1th_char_taken;
        return dp[i];
    }
}

// Bottom-Up DP
class Solution3 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0')
            return 0;

        int[] dp = new int[n + 1];
        dp[n] = 1; // base case: one way to decode an empty string

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0; // cannot decode a string starting with '0'
            } else {
                dp[i] = dp[i + 1]; // take only the ith character
                if (i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                    dp[i] += dp[i + 2]; // take both ith and (i+1)th characters
                }
            }
        }

        return dp[0]; // return the number of ways to decode the string [0...n-1]
    }
}