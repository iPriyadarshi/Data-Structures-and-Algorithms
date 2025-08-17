# Approach 1: BruteForce
# Time Complexity: O(N * maxPts) - nested loops iterating through N and maxPts
# Space Complexity: O(N) - using prob_arr of size N+1

class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        prob_arr = [0] * (n + 1)
        prob_arr[0] = 1
        for i in range(1, n + 1):
            for j in range(1, maxPts + 1):
                if i - j >= 0 and i - j < k:
                    prob_arr[i] += prob_arr[i - j] / maxPts
        result = 0
        for i in range(k, n + 1):
            result += prob_arr[i]
        return result
    
# Approach 2: Optimized
# Time Complexity: O(N) - single loop from 1 to N
# Space Complexity: O(N) - using prob_arr of size N+1

class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        prob_arr = [0] * (n + 1)
        prob_arr[0] = 1

        currProbSum = 0 if k == 0 else 1

        for i in range(1, n + 1):
            prob_arr[i] = currProbSum / maxPts
            if i < k:
                currProbSum += prob_arr[i]
            if i - maxPts >= 0 and i - maxPts < k:
                currProbSum -= prob_arr[i - maxPts]

        return sum(prob_arr[k:])
