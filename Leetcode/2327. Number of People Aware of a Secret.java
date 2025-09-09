import java.util.Arrays;

// Approach-1 - Recursion + Memoization
// T.C : O(n * (forget - delay))
// S.C : O(n)


class Solution {
    int M = 1000000007;
    int n, delay, forget;
    int[] dp; // memoization array

    // solve(day) = number of people who knows the secret on "day"
    private int solve(int day) {
        if (day == 1)
            return 1;
        if (day <= 0)
            return 0;

        if (dp[day] != -1)
            return dp[day];

        long result = 0;
        // people who can share today are those who learned in [day - forget + 1, day - delay]
        for (int prev = day - forget + 1; prev <= day - delay; prev++) {
            if (prev > 0) {
                result = (result + solve(prev)) % M;
            }
        }

        return dp[day] = (int) result;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        this.n = n;
        this.delay = delay;
        this.forget = forget;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int total = 0;
        // only count people who still remember on day n
        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) {
                total = (total + solve(day)) % M;
            }
        }

        return total;
    }
}

// Approach 2: Bottom Up ----- Coming Soon!