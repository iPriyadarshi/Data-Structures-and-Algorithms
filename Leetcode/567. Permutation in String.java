class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int left = 0;
        int right = left + n1 - 1;
        while (right < n2) {
            if (isAnagram(s1, s2.substring(left, right + 1))) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    private boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
            freq[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}