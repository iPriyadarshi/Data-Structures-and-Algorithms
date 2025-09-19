import java.util.ArrayList;
import java.util.List;

// T.C: O(n * m) where n is number of queries and m is length of pattern
// S.C: O(1)

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> answer = new ArrayList<>();
        for (String query : queries) {
            answer.add(isMatch(query, pattern));
        }
        return answer;
    }

    private boolean isMatch(String query, String pattern) {
        int i = 0, j = 0;
        while (i < query.length()) {
            char c1 = query.charAt(i);
            if (j < pattern.length() && c1 == pattern.charAt(j)) {
                i++;
                j++;
            } else if (Character.isUpperCase(c1)) {
                return false;
            } else {
                i++;
            }
        }
        // Ensure the entire pattern was matched
        return j == pattern.length();

    }
}