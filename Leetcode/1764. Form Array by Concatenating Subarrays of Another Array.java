// T.C: O(n * m) where n is number of groups and m is length of nums
// S.C: O(1)

class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0; // Pointer for groups
        int j = 0; // Pointer for nums

        while (i < groups.length && j < nums.length) {
            int[] group = groups[i];
            if (canFormGroup(group, nums, j)) {
                j += group.length;
                i++;
            } else {
                j++;
            }
        }
        // If we have formed all groups, return true
        return i == groups.length;
    }

    private boolean canFormGroup(int[] group, int[] nums, int start) {
        if (start + group.length > nums.length) return false;

        for (int k = 0; k < group.length; k++) {
            if (group[k] != nums[start + k]) return false;
        }
        return true;
    }
}