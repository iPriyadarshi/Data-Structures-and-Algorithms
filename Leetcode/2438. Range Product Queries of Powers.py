from typing import List

class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        M = int(1e9 + 7)

        # Extract powers of 2 from binary representation of n
        powers = []
        for i in range(n.bit_length()):
            if (n & (1 << i)) != 0: # ith bit is set
                powers.append(1 << i)  # 2^i

        result = []
        for i in range(len(queries)):
            left, right = queries[i]
            prod = 1
            for j in range(left, right + 1):
                prod = (prod * powers[j]) % M
            result.append(prod)

        return result
