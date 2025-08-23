class Solution {
    /*
     * Time Complexity: O(n + m) where n and m are lengths of nums1 and nums2
     * Space Complexity: O(1) since frequency array has fixed size 1001
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // Frequency array for nums1
        int[] freq = new int[1001]; // Frequency array for values 0 to 1000

        // Count frequencies in nums1
        for (int num : nums1) {
            freq[num]++;
        }

        // Build result using nums2
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;

        for (int num : nums2) {
            if (freq[num] > 0) {
                temp[index] = num;
                index++;
                freq[num]--;
            }
        }

        // Copy result to final array of correct size
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}