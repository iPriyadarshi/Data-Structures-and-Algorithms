import java.util.Arrays;
import java.util.Comparator;

// T.C: O(n log n), where n is the number of points
// S.C: O(log n) due to sorting because in Java, the Arrays.sort() for primitives is implemented as a variant of the quicksort algorithm whose space complexity is O(log n)

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // Sort by x-coordinate using Comparator.comparingInt
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        // Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); // Alternative way to sort by x-coordinate

        int maxArea = 0;
        for (int i = 0; i < points.length - 1; i++) {
            maxArea = Math.max(maxArea, points[i + 1][0] - points[i][0]);
        }
        return maxArea;
    }
}