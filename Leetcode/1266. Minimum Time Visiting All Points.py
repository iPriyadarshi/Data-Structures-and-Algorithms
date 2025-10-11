from typing import List


class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        # T.C = O(N), N = len(points)
        # S.C = O(1)
        n = len(points)
        total_time = 0
        for i in range(n - 1):
            point1 = points[i]
            point2 = points[i + 1]
            time = max(abs(point1[0] - point2[0]), abs(point1[1] - point2[1]))
            total_time += time
        return total_time
