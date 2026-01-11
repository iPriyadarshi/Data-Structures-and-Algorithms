import java.util.HashSet;

class Solution {
    public int residuePrefixes(String s) {
        int residue = 0;
        String[] prefixes = new String[s.length()];

        // Generate all prefixes
        for (int i = 0; i < s.length(); i++) {
            prefixes[i] = s.substring(0, i + 1);
        }

        // Check if prefix is residue or not and update count
        for (String prefix : prefixes) {
            if (isResidue(prefix)) {
                residue++;
            }
        }
        return residue;
    }

    private boolean isResidue(String prefix) {
        HashSet<Character> set = new HashSet<>();
        for (char c : prefix.toCharArray()) {
            set.add(c);
        }
        if (prefix.length() % 3 == set.size()) {
            return true;
        } else {
            return false;
        }
    }
}