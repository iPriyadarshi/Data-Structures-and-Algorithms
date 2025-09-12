import java.util.Arrays;

// Approach-1 (Separate string create and sort)
// T.C : O(nlogn)
// S.C : O(n)

class Solution {
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public String sortVowels(String s) {
        // Extract vowels
        StringBuilder temp = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                temp.append(ch);
            }
        }

        // Sort the extracted vowels
        char[] tempArray = temp.toString().toCharArray();
        Arrays.sort(tempArray);
        
        // Place sorted vowels back into original string
        int j = 0;
        char[] resultArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                resultArray[i] = tempArray[j];
                j++;
            }
        }

        return new String(resultArray);
    }
}
