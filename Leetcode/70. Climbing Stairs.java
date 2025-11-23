import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}

class Solution2 {
    public int climbStairs(int n) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        if (n <= 2)
            return n;

        int prev2 = 1, prev = 2;
        int curr;
        for (int i = 3; i <= n; i++) {
            curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}