/**
 * Time Complexity: O(1) - Constant time operations
 * Space Complexity: O(1) - No extra space used
 */
class Solution {
    public int findClosest(int x, int y, int z) {
        int dist_xz = Math.abs(x - z);
        int dist_yz = Math.abs(y - z);

        if (dist_xz == dist_yz) {
            return 0;
        } else if (dist_xz < dist_yz) {
            return 1;
        } else {
            return 2;
        }

    }
}