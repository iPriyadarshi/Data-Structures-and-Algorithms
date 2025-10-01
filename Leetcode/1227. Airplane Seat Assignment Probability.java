// T.C: O(1)
// S.C: O(1)

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1)
            return 1;
        else
            return 0.5;
    }
}

// Explanation: Airplane Seat Assignment Probability Problem
// If there is only one person, they will obviously sit in their own seat, so the probability is 1.
// For more than one person, the first person has a 50% chance of sitting in their own seat or the last person's seat, leading to a 50% probability for the nth person to sit in their own seat.
// For any other seat chosen by the first person, the problem reduces to a smaller version of itself, maintaining the 50% probability.
