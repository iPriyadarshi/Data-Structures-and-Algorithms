
class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long totalHours = 0;
            for (int pile : piles) {
                int hours;
                if (pile % mid == 0) {
                    hours = pile / mid;
                } else {
                    hours = pile / mid + 1;
                }
                totalHours += hours;
            }

            if (totalHours <= h) {
                high = mid - 1; // try smaller k
            } else {
                low = mid + 1;  // need bigger k
            }
        }

        return low;
    }
}
