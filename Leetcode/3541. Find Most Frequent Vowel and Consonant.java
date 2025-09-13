import java.util.HashMap;

// Time Complexity: O(n), where n is the length of the string s.
// Space Complexity: O(1), since the frequency map will contain at most 52 entries

class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                maxVowelFreq = Math.max(maxVowelFreq, freqMap.get(c));
            } else if (Character.isLetter(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                maxConsonantFreq = Math.max(maxConsonantFreq, freqMap.get(c));
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}