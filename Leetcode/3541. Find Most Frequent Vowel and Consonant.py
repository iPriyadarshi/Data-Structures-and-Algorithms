class Solution:
    def maxFreqSum(self, s: str) -> int:
        vowel = {"a": 0, "e": 0, "i": 0, "o": 0, "u": 0}
        consonant = {}

        for ch in s:
            if ch in vowel:
                vowel[ch] += 1
            else:
                if ch in consonant:
                    consonant[ch] += 1
                else:
                    consonant[ch] = 1
        vow_max = 0
        cons_max = 0
        for key, val in vowel.items():
            if val > vow_max:
                vow_max = val
        for key, val in consonant.items():
            if val > cons_max:
                cons_max = val
        return vow_max + cons_max
