# Approach 1: Using Recursion (Brute-Force)
# Time Complexity: O(2^(n^(1/x))), as each number can be either taken or skipped
# Space Complexity: O(n^(1/x)), due to recursion stack depth up to maxNum


class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        M = int(1e9 + 7)
        maxNum = int(n ** (1 / x)) + 1

        def solve(remain, num):
            if remain == 0:
                return 1
            if remain < 0 or num > maxNum:
                return 0

            currPowerValue = num**x
            take = solve(remain - currPowerValue, num + 1)
            skip = solve(remain, num + 1)
            return (take + skip) % M

        return solve(n, 1)


# Approach 2: Using memoization
# Time Complexity: O(n * maxNum), where maxNum = n^(1/x)
# Space Complexity: O(n * maxNum) for the dp table


class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        M = int(1e9 + 7)
        maxNum = int(n ** (1 / x)) + 1  # max base number to consider
        dp = [[-1 for _ in range(maxNum + 1)] for _ in range(n + 1)]

        def solve(remain, num):  # remain == n
            if remain == 0:
                return 1
            if remain < 0 or num > maxNum:
                return 0
            if dp[remain][num] != -1:
                return dp[remain][num]

            currPowerValue = num**x
            take = solve(remain - currPowerValue, num + 1)
            skip = solve(remain, num + 1)
            dp[remain][num] = (take + skip) % M
            return dp[remain][num]

        return solve(n, 1)
