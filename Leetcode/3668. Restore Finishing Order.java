import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    /**
     * Time Complexity: O(n + m) where:
     * - n is the length of order array
     * - m is the length of friends array
     * 
     * Space Complexity: O(m) where:
     * - m is the length of friends array (for HashSet storage)
     * - Additional O(m) space for the result array/list
     */
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> friendSet = new HashSet<>();
        for (int id : friends) { // O(m) time
            friendSet.add(id);
        }

        List<Integer> result = new ArrayList<>();
        for (int id : order) { // O(n) time
            if (friendSet.contains(id)) { // O(1) lookup
                result.add(id);
            }
        }

        // Convert List<Integer> to int[]
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) { // O(m) time at worst
            resArray[i] = result.get(i);
        }

        return resArray;
    }
}