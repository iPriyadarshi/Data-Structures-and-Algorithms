// Approach 1: Linear Search
class Solution1 {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = 0;
        for(char c : letters){
            if(c <= target){
                index++;
            } else {
                return c;
            }
        }
        return letters[0];
    }
}

// Approach 2: Binary Search
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length;

        // Binary search for the first letter greater than target
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;   // move right if mid is too small
            } else {
                r = mid;       // keep mid as possible answer
            }
        }

        // If l == letters.length, wrap around to first element
        return letters[l % letters.length];
    }
}