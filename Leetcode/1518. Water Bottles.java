// ====================================================== Approach 1: Simulation ============================================
// T.C: O(logn)
// S.C: O(1)

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        while (numBottles >= numExchange) {
            int bottleExchanged = numBottles / numExchange;
            result += bottleExchanged;
            numBottles = (numBottles % numExchange) + bottleExchanged;
        }
        return result;
    }
}

// =================================================== Approach 2: Mathematical ===================================================
// T.C: O(1)
// S.C: O(1)

// class Solution {
//     public int numWaterBottles(int numBottles, int numExchange) {
//         return numBottles + (numBottles - 1) / (numExchange - 1);
//     }
// }