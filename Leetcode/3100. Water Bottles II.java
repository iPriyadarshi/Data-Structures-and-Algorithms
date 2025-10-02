// T.C: O(n), where n is the number of bottles
// S.C: O(1)

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = 0;
        int bottlesDrunk = 0;
        // Edge case
        if (numBottles < numExchange){
            return numBottles;
        }
        // Simulation
        while (numBottles + emptyBottles >= numExchange) {
            // Exchange
            while (emptyBottles >= numExchange) {
                emptyBottles -= numExchange;
                numExchange += 1;
                numBottles += 1;
            }
            // Drink
            emptyBottles += numBottles;
            bottlesDrunk += numBottles;
            numBottles = 0;
        }
        return bottlesDrunk;
    }
}