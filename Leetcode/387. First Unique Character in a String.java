class Solution {
    // T.C = O(n)
    // S.C = O(26) = O(1)
    public int firstUniqChar(String s) {
        int[] freq = new int[26]; // Frequency array for 'a' to 'z'

        // First pass: count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Second pass: find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1; // No unique character found
    }
}