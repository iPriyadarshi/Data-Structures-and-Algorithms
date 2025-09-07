/**
 * Time Complexity: O(n/2) ≈ O(n), where n is the input integer
 * We iterate from 1 to n/2 to fill the array
 * 
 * Space Complexity: O(n)
 * We create an array of size n to store the result
 */
class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        if (n % 2 != 0)
            result[index++] = 0;
        for (int i = 1; i <= n / 2; i++) {
            result[index++] = i;
            result[index++] = -i;
        }
        return result;
    }
}