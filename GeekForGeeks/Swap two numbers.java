// https://www.geeksforgeeks.org/problems/swap-two-numbers3844/0

import java.util.*;

class Solution {
    static List<Integer> get(int a, int b) {
        // Swapping using XOR
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        // Return as a list
        List<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }
}