// T.C: O(n) where n is length of s
// S.C: O(n) where n is length of s

class Solution {
    public boolean rotateString(String s, String goal) {
        int s_len = s.length();
        int goal_len = goal.length();

        if (s_len != goal_len) {
            return false;
        }

        String doubled_s = s + s;
        return doubled_s.contains(goal);
    }
}