import java.util.Arrays;

//T.C : O(n^2)
//S.C : O(1)

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        // Sort: x ascending, if x same then sort as y descending
        Arrays.sort(points, (point1, point2) -> {
            if (point1[0] == point2[0]) {
                return point2[1] - point1[1];
            }
            return point1[0] - point2[0];
        });

        int result = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1]; // upper left

            int maxY = Integer.MIN_VALUE; // maxY of middle elements

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1]; // lower right

                // Condition: (x2, y2) must be above (x1, y1)
                if (y2 > y1) { //not lower right
                    continue;
                }

                if (y2 > maxY) {
                    result++;
                    maxY = y2;
                }
            }
        }

        return result;
    }
};