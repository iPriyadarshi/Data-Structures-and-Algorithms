//Approach (Simple Recursion - DFS)
//T.C : O(n) - We visit each number (1 to n) only once.
//S.C : O(d) - where d is the number of digits in n i.e. log10(n)

import java.util.ArrayList;
import java.util.List;

class Solution {

    private void solve(int currNum, int n, List<Integer> result) {
        if (currNum > n) {
            return;
        }

        result.add(currNum); // Add current number to result

        // Generate the next number by appending digits 0 to 9
        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            int nextNum = currNum * 10 + nextDigit;

            if (nextNum > n) {
                return;
            }

            solve(nextNum, n, result); // Recursive call
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        // Start from numbers 1 to 9
        for (int startNum = 1; startNum <= 9; startNum++) {
            solve(startNum, n, result);
        }

        return result; // Return the result list
    }
}