# Approach 1: Using Sorting
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        str_map = {}
        for word in strs:
            key = self.generate(word)
            if key not in str_map:
                str_map[key] = []
            str_map[key].append(word)

        return list(str_map.values())

    def generate(self, word: str) -> str:
        arr = [0] * 26
        for ch in word:
            arr[ord(ch) - ord("a")] += 1

        # Build a string like "a2b1c3" for the frequency signature
        new_word = ""
        for i in range(26):
            if arr[i] > 0:
                new_word += chr(i + ord("a")) + str(arr[i])

        return new_word

# Approach 2: Without Sorting
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        str_map = {}
        for word in strs:
            key = self.generate(word)
            if key not in str_map:
                str_map[key] = []
            str_map[key].append(word)

        return list(str_map.values())

    def generate(self, word: str) -> str:
        arr = [0] * 26
        for ch in word:
            arr[ord(ch) - ord("a")] += 1

        # Build a string like "a2b1c3" for the frequency signature
        new_word = ""
        for i in range(26):
            if arr[i] > 0:
                new_word += chr(i + ord("a")) + str(arr[i])

        return new_word