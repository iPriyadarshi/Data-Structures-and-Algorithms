// T.C: O(n)
// S.C: O(1)

class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                result |= num;
            }
        }
        return result;
    }
}