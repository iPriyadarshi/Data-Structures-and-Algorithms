class Solution:
    def myPow(self, x: float, n: int) -> float:
        # If n is 0, return 1 (any number to power 0 is 1)
        if n == 0:
            return 1.0

        # If n is negative, use 1/x and make n positive
        if n < 0:
            x = 1 / x
            n = -n

        # Start with result = 1 and base = x
        result = 1.0
        base = x

        # Process n using binary exponentiation
        while n > 0:
            # If n is odd, multiply result by base
            if n % 2 == 1:
                result = result * base
            # Square the base (base = base * base)
            base = base * base
            # Divide n by 2
            n = n // 2

        return result