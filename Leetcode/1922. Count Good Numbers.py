class Solution:
    M = int(1e9 + 7)

    def findPower(self, a: int, b: int) -> int:
        """
        Calculate power using binary exponentiation.
        Time complexity: O(log b)

        Args:
            a: base number
            b: exponent

        Returns:
            result of a^b mod M
        """
        if b == 0:
            return 1

        half = self.findPower(a, b // 2)
        result = (half * half) % self.M

        if b % 2 == 1:
            result = (result * a) % self.M

        return result

    def countGoodNumbers(self, n: int) -> int:
        """
        Count good numbers of length n.
        - Even indices can have digits: 0,2,4,6,8 (5 possibilities)
        - Odd indices can have digits: 2,3,5,7 (4 possibilities)
        - Total good numbers = (5^even_indices) * (4^odd_indices)

        Returns:
            number of good numbers mod M
        """
        return (self.findPower(5, (n + 1) // 2) * self.findPower(4, n // 2)) % self.M
