class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if ((long) m * k > n)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // search boundaries
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(bloomDay, m, k, mid)) {
                answer = mid;
                high = mid - 1; // explore lower days
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private boolean isValid(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
