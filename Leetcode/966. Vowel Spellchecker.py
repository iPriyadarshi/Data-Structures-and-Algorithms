from typing import List

class Solution:
    # Helper function to check if a character is a vowel
    def is_vowel(self, ch: str) -> bool:
        return ch.lower() in "aeiou"

    # Helper function to replace vowel with *
    def devowel(self, word: str) -> str:
        return "".join("*" if self.is_vowel(c) else c.lower() for c in word)

    # Case-insensitive match: returns first word from wordlist that matches query ignoring case
    def capitalization(self, wordlist, query):
        for word in wordlist:
            if word.lower() == query.lower():
                return word
        return ""

    # Vowel-error match: replaces vowels with '*' and compares normalized forms
    def vowel_errors(self, wordlist, query):
        query_devowel = self.devowel(query)
        for word in wordlist:
            if self.devowel(word) == query_devowel:
                return word
        return ""

    # Main spellchecker function
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        # Maps for case-insensitive and vowel-error matches
        lower_map = {}  # key: lowercase word, value: original word
        vowel_map = {}  # key: devoweled word, value: original word

        # Preprocess wordlist to fill maps
        for word in wordlist:
            lower = word.lower()
            devowel = self.devowel(word)

            # Store first occurrence only
            if lower not in lower_map:
                lower_map[lower] = word
            if devowel not in vowel_map:
                vowel_map[devowel] = word

        # Process each query
        answer = []
        for query in queries:
            if query in wordlist:
                answer.append(query)  # Exact match
            elif query.lower() in lower_map:
                answer.append(lower_map[query.lower()])  # Case-insensitive match
            else:
                devowel = self.devowel(query)
                answer.append(vowel_map.get(devowel, ""))  # Vowel-error match or empty
        return answer
