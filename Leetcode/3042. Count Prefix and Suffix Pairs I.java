// T.C : O(n^2 * m) where n is number of words and m is average length of each word
// S.C : O(1)

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        // check if str1 is prefix and suffix of str2
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 > len2)
            return false;

        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                return false; // prefix check
            if (str1.charAt(len1 - 1 - i) != str2.charAt(len2 - 1 - i))
                return false; // suffix check
        }
        return true;
    }
}