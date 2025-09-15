class Solution:
    # T.C: O(N*M) where N is total number of words and M is average length of each word
    # S.C: O(K) where K is length of brokenLetters for creating the set
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        words = text.split()
        broken_set = set(brokenLetters) # Create a set of broken letters for O(1) lookups
        count = 0
        for word in words:
            if not any(char in broken_set for char in word):
                count += 1
        return count
