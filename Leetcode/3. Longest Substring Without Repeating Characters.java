
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;
        int maxLen = 0;
        while (r < n) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
