// Time Complexity: O(n), where n is the length of the string
// Space Complexity: O(1), constant space used

class Solution {
    public boolean doesAliceWin(String s) {
        for (char ch : s.toCharArray()) {
            // indexOf returns -1 if ch is not found in "aeiou" => no vowels found
            // If atleast one vowel is found, Alice wins
            if ("aeiou".indexOf(ch) != -1) {
                return true;
            }
        }
        // No vowels found, Bob wins
        return false;
    }
}