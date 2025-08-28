import java.util.*;

// Approach 1
// Time Complexity: O(n^2 * log(n)) - due to sorting each diagonal of length O(n)
// Space Complexity: O(n) - for storing diagonal elements in ArrayList

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Bottom-left triangle including the main diagonal
        for (int row = 0; row < n; row++) {
            sortDiagonal(row, 0, grid, false); // non-increasing order
        }

        // Top-right triangle excluding the main diagonal
        for (int col = 1; col < n; col++) {
            sortDiagonal(0, col, grid, true); // non-decreasing order
        }

        return grid;
    }

    private void sortDiagonal(int r, int c, int[][] grid, boolean ascending) {
        int n = grid.length;
        List<Integer> diagonal = new ArrayList<>();

        // Collect the diagonal
        int i = r, j = c;
        while (i < n && j < n) {
            diagonal.add(grid[i][j]);
            i++;
            j++;
        }

        // Sort the diagonal
        if (ascending) {
            Collections.sort(diagonal);
        } else {
            diagonal.sort(Collections.reverseOrder());
        }

        // Write back the sorted values
        i = r;
        j = c;
        int idx = 0;
        while (i < n && j < n) {
            grid[i][j] = diagonal.get(idx++);
            i++;
            j++;
        }
    }
}

// Approach 2
// Time Complexity: O(n^2 * log(n)) - due to sorting diagonals
// Space Complexity: O(n^2) - storing all elements in HashMap

// class Solution {
//     public int[][] sortMatrix(int[][] grid) {
//         int n = grid.length;
//         Map<Integer, List<Integer>> diagMap = new HashMap<>();

//         // Step 1: Group elements by their diagonal (i - j)
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int key = i - j;
//                 diagMap.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
//             }
//         }

//         // Step 2: Sort each diagonal based on its region
//         for (Map.Entry<Integer, List<Integer>> entry : diagMap.entrySet()) {
//             List<Integer> list = entry.getValue();
//             if (entry.getKey() < 0) {
//                 Collections.sort(list); // ascending
//             } else {
//                 list.sort(Collections.reverseOrder()); // descending
//             }
//         }

//         // Step 3: Write back sorted values
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int key = i - j;
//                 grid[i][j] = diagMap.get(key).remove(0);
//             }
//         }

//         return grid;
//     }
// }

// Optimized approach 2
// Time Complexity: O(n^2 * log(n)) - same as Approach 2
// Space Complexity: O(n^2) - storing all elements in HashMap
// Note: While space complexity remains same, this approach is more efficient for write-back operations as it uses O(1) remove operation from end of list instead of O(n) from beginning

// class Solution {
//     public int[][] sortMatrix(int[][] grid) {
//         int n = grid.length;
//         Map<Integer, List<Integer>> diagMap = new HashMap<>();

//         // Step 1: Group elements by diagonal key (i - j)
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int key = i - j;
//                 diagMap.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
//             }
//         }

//         // Step 2: Sort each diagonal in reverse direction
//         for (Map.Entry<Integer, List<Integer>> entry : diagMap.entrySet()) {
//             List<Integer> list = entry.getValue();
//             if (entry.getKey() < 0) {
//                 list.sort(Collections.reverseOrder()); // ascending write → reverse sort
//             } else {
//                 Collections.sort(list); // descending write → normal sort
//             }
//         }

//         // Step 3: Write back using remove from end (O(1))
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int key = i - j;
//                 List<Integer> list = diagMap.get(key);
//                 grid[i][j] = list.remove(list.size() - 1);
//             }
//         }

//         return grid;
//     }
// }