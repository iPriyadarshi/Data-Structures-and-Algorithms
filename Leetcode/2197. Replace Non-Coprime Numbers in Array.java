// Approach: Using Stack
// T.C : O(n * log(min(a, b))) where n is the length of nums and a, b are the two numbers for which we are calculating gcd
// S.C : O(1)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            // Keep merging while the last number and current num are non-coprime
            while (!result.isEmpty()) {
                int prev = result.get(result.size() - 1);
                int g = gcd(prev, num);

                if (g == 1) {
                    break; // coprime, stop merging
                }

                // Remove last and merge with current
                result.remove(result.size() - 1);
                long lcm = (long) prev / g * num; // use long to avoid overflow
                num = (int) lcm;
            }
            result.add(num);
        }

        return result;
    }

    // Euclidean algorithm for GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}