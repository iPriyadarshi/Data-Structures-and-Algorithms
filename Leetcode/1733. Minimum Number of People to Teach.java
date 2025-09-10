import java.util.HashSet;
import java.util.Set;

// Approach (Greedily picking the mostKnown language among the sadUsers (those who cannpt talk to their friends))
// T.C : O(m*n)
// S.C : O(m+n)

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> sadUsers = new HashSet<>(); // users who can't talk to their friend

        // Find sadUsers
        for (int[] friends : friendships) {
            int u = friends[0] - 1; // 0 based indexing
            int v = friends[1] - 1; // 0 based indexing

            // check if u and v share a common language
            Set<Integer> langSet = new HashSet<>();
            for (int lang : languages[u]) {
                langSet.add(lang);
            }

            boolean canTalk = false;
            for (int lang : languages[v]) {
                if (langSet.contains(lang)) {
                    canTalk = true;
                    break;
                }
            }

            // if they cannot talk, mark them as sad
            if (!canTalk) {
                sadUsers.add(u);
                sadUsers.add(v);
            }
        }

        // Count how many sadUsers already know each language
        int[] languageUserCount = new int[n + 1];
        int mostKnownLangUserCount = 0;

        for (int user : sadUsers) {
            for (int lang : languages[user]) {
                languageUserCount[lang]++;
                mostKnownLangUserCount = Math.max(mostKnownLangUserCount, languageUserCount[lang]);
            }
        }

        // total sadUsers - mostKnownLang
        return sadUsers.size() - mostKnownLangUserCount;
    }
}