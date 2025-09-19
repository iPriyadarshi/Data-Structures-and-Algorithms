import java.util.List;

// T.C : O(n^2 * m) where n is number of words and m is average length of each word
// S.C : O(1)

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new java.util.ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isSubstring(words[i], words[j])) {
                    result.add(words[i]);
                    break; // no need to check further
                }
            }
        }
        return result;
    }

    private boolean isSubstring(String str1, String str2) {
        // check if str1 is substring of str2
        if (str2.contains(str1)) {
            return true;
        } else {
            return false;
        }
    }
}