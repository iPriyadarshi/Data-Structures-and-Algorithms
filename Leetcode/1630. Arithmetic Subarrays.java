import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// T.C: O(m * n log n) where m is the length of l (or r) and n is the maximum length of the subarrays
// S.C: O(n) for the space used to store the subarray

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];
            // Extract subarray from nums
            int[] subarray = Arrays.copyOfRange(nums, left, right + 1);
            boolean ans = isArithmeticSequence(subarray);
            result.add(ans);
        }
        return result;
    }

    private boolean isArithmeticSequence(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) {
                return false;
            }
        }
        return true;
    }
}