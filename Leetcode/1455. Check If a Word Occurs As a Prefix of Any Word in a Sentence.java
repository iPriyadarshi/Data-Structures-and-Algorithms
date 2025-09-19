// T.C : O(n * m) where n is number of words and m is average length of each word
// S.C : O(1)

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1; // 1-based index
            }
        }

        return -1;

    }
}