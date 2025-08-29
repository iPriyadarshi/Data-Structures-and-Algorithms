// ========================================== Approach 1: Brute Force --TLE ===============================================

// Time Complexity: O(n*m) - as we need to iterate through all possible combinations of x and y
// Space Complexity: O(1) - only using a single variable to store count

// class Solution {
//     public long flowerGame(int n, int m) {
//         long count = 0;
//         for (int x = 1; x <= n; x++) {
//             for (int y = 1; y <= m; y++) {
//                 if ((x + y) % 2 != 0) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }



// ========================================== Approach 2: Mathematical ===============================================

// Time Complexity: O(1) - constant time operations only
// Space Complexity: O(1) - using only a few variables regardless of input size

class Solution {
    public long flowerGame(int n, int m) {
        long oddX = n / 2 + n % 2;
        long evenX = n / 2;
        long oddY = m / 2 + m % 2;
        long evenY = m / 2;
        return oddX * evenY + evenX * oddY;
    }
}