class Solution:
    def reverseDegree(self, s: str) -> int:
        result = 0
        for i, char in enumerate(s):
            position_in_string = i + 1  # 1-indexed
            reverse_alphabet_value = 26 - (ord(char) - ord("a"))
            result += reverse_alphabet_value * position_in_string
        return result
