// T.C: O(n * m) where n is the number of words and m is the length of the prefix
// S.C: O(1)

class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}