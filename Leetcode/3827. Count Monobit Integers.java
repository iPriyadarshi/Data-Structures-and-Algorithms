class Solution {
    public int countMonobit(int n) {
        if (n==0){
            return 1;
        }
        int total = 1;
        int repeatedOnes = 1;   // 1111..111
        
        while(repeatedOnes<=n){
            total += 1;
            repeatedOnes = (repeatedOnes<<1) | 1;   // left shift and set last bit to 1
        }
        return total;
    }
}