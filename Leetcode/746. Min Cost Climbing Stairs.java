class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
}

class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        int downOne = 0, downTwo = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int current = cost[i] + Math.min(downOne, downTwo);
            downTwo = downOne;
            downOne = current;
        }
        return Math.min(downOne, downTwo);
    }
}
