from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        n = len(digits)

        num_letter = {
            2: ["a", "b", "c"],
            3: ["d", "e", "f"],
            4: ["g", "h", "i"],
            5: ["j", "k", "l"],
            6: ["m", "n", "o"],
            7: ["p", "q", "r", "s"],
            8: ["t", "u", "v"],
            9: ["w", "x", "y", "z"],
        }

        if n == 0:
            return []

        result = []
        for i in range(n):
            current_digit = int(digits[i])
            letters = num_letter[current_digit]
            if i == 0:
                result = letters
            else:
                temp = []
                for combination in result:
                    for letter in letters:
                        temp.append(combination + letter)
                result = temp
        return result
