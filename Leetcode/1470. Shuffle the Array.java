class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        
        int idx = 0;
        for(int i=0;i<n;i++){
            res[idx] = nums[i];
            idx++;
            res[idx] = nums[i+n];
            idx++;
        }
        return res;
    }
}