class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] aAfter = new int[n];
        int[] bBefore = new int[n];

        int aCount = 0;
        int bCount = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
            aAfter[i] = aCount;
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            }
            bBefore[i] = bCount;
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, aAfter[i] + bBefore[i]);
        }

        return minCost - 1;
    }
}