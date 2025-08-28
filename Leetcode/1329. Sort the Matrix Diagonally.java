import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /**
     * Time Complexity: O(M*N*log(D)) where:
     * - M = number of rows
     * - N = number of columns
     * - D = min(M,N) is the maximum possible length of a diagonal
     * 
     * Space Complexity: O(M*N) to store all elements in the HashMap
     */
    
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Map to store diagonals with key = i - j
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Store diagonal elements - O(M*N)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(i - j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        // Step 2: Sort each diagonal - O(M*N*log(D))
        // Each element is in exactly one diagonal, and each diagonal is sorted separately
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        // Step 3: Put sorted values back - O(M*N)
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int key = i - j;
                List<Integer> list = map.get(key);
                mat[i][j] = list.remove(list.size() - 1); // pop from back
            }
        }

        return mat;
    }
}