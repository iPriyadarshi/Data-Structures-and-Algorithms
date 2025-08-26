/**
 * Finds the area of the rectangle with the longest diagonal among given rectangles.
 * If multiple rectangles have the same longest diagonal, returns the maximum area among them.
 *
 * @param dimensions A 2D array where each row contains [length, width] of a rectangle
 * @return The area of the rectangle with longest diagonal (or maximum area if multiple have same diagonal)
 * 
 * Time Complexity: O(n) where n is the number of rectangles
 * Space Complexity: O(1) as only constant extra space is used
 */

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double longestDiag = 0;

        for (int i = 0; i < dimensions.length; i++) {
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            double diagLen = Math.sqrt(l * l + w * w);
            int area = l * w;
            if (diagLen > longestDiag) {
                longestDiag = diagLen;
                maxArea = area;
            } else if (diagLen == longestDiag) {
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}