class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = 0;
        for(char c : letters){
            if(c <= target){
                index++;
            } else {
                return c;
            }
        }
        return letters[0];
    }
}