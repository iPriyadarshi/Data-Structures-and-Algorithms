class Solution {
    /**
     * Time Complexity: O(n * m) - where n is the length of landStartTime and m is the length of waterStartTime
     * Space Complexity: O(1) - No extra space used
     */
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int landThenWater = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j];
                int waterThenLand = Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i];
                minTime = Math.min(minTime, Math.min(landThenWater, waterThenLand));
            }
        }
        return minTime;
    }
}
