from typing import List


class Solution:
    def countPoints(self, points: List[List[int]], queries: List[List[int]]) -> List[int]:
        # T.C = O(N * M), N = len(points), M = len(queries)
        # S.C = O(1)
        answer = []
        for query in queries:
            c1, c2, r = query[0], query[1], query[2]
            count = 0
            for point in points:
                x, y = point[0], point[1]
                sqrt_dist_from_centre = (c1 - x) ** 2 + (c2 - y) ** 2
                if sqrt_dist_from_centre <= r**2:
                    count += 1
            answer.append(count)
        return answer