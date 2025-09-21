import java.util.Arrays;

// T.C: O(nlogn) due to sorting
// S.C: O(1)

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int coins = 0;
        int i = n;

        while (i < 3 * n) {
            coins += piles[i];
            i += 2;
        }
        return coins;
    }
}