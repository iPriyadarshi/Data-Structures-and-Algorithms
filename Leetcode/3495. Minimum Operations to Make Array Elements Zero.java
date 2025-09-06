// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.PriorityQueue;

// ================================================ Approach 1: Simulation =================================================

// class Solution {
//     public long minOperations(int[][] queries) {
//         /*
//          * Time Complexity: O(Q * N * log N) -- TLE
//          * - Q is the number of queries
//          * - N is the maximum range (r-l+1) in any query
//          * - log N comes from sorting the list in each iteration
//          * 
//          * Space Complexity: O(N), where N is the maximum range (r-l+1) in any query
//          * - We store the operations list for each range
//          */
//         long totalOps = 0;

//         for (int[] query : queries) {
//             int l = query[0];
//             int r = query[1];

//             // Compute ops_needed = floor(log4(x)) + 1 for each x in [l, r]
//             List<Integer> opsList = new ArrayList<>();
//             for (int x = l; x <= r; x++) {
//                 int ops = (int) Math.floor(Math.log(x) / Math.log(4)) + 1;
//                 opsList.add(ops);
//             }
//             // Always pair the 2 numbers with the maximum "/4" operations needed.
//             // And reduce ops needed in opsList by 1 after each operation until ops needed
//             // becomes 0 for all number in nums array
//             while (sum(opsList) != 0) {
//                 opsList.sort(Collections.reverseOrder());
//                 opsList.set(0, opsList.get(0) - 1);
//                 opsList.set(1, opsList.get(1) - 1);
//                 totalOps += 1;
//             }
//         }
//         return totalOps;
//     }

//     private int sum(List<Integer> opsList) {
//         int total = 0;
//         for (int num : opsList) {
//             total += num;
//         }
//         return total;
//     }
// }


// ===================================== Approach 2: Using Priority Queue ========================================

// class Solution {
//     public long minOperations(int[][] queries) {
//         /*
//          * Time Complexity: O(Q * N * log N) -- TLE
//          * - Q is the number of queries
//          * - N is the maximum range (r-l+1) in any query
//          * - log N comes from heap operations (insert and remove)
//          * 
//          * Space Complexity: O(N), where N is the maximum range (r-l+1) in any query
//          * - We store elements in the priority queue
//          */
//         long totalOps = 0;

//         for (int[] query : queries) {
//             int l = query[0];
//             int r = query[1];

//             PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

//             for (int x = l; x <= r; x++) {
//                 int ops = (int) Math.floor(Math.log(x) / Math.log(4)) + 1;
//                 if (ops > 0)
//                     maxHeap.offer(ops);
//             }

//             while (maxHeap.size() > 1) {
//                 int first = maxHeap.poll();
//                 int second = maxHeap.poll();

//                 first--;
//                 second--;
//                 totalOps++;

//                 if (first > 0)
//                     maxHeap.offer(first);
//                 if (second > 0)
//                     maxHeap.offer(second);
//             }

//             // Handle leftover element if any
//             if (!maxHeap.isEmpty()) {
//                 totalOps += maxHeap.poll(); // Each op is solo now
//             }
//         }

//         return totalOps;
//     }
// }

// ========================== Approach 3: (Using Power-Of-Four-Ranges for Steps of Reduction to 0) ======================

// T.C = O(Q * log(max r)), Q =  number of queries, r = right value of ranges
// S.C = O(1)

class Solution {
    private long solve(int l, int r) {
        long L = 1; // starting point of range
        long S = 1; // steps multiplier
        long steps = 0;

        while (L <= r) {
            long R = 4 * L - 1; // end point of current range

            long start = Math.max(L, (long) l);
            long end = Math.min(R, (long) r);

            if (start <= end) {
                steps += (end - start + 1) * S;
            }

            S += 1;
            L = L * 4;
        }

        return steps;
    }

    public long minOperations(int[][] queries) {
        long result = 0;

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            long steps = solve(l, r);
            result += (steps + 1) / 2;
        }

        return result;
    }
}