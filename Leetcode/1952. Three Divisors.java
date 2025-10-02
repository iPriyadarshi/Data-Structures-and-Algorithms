// T.C: O(√n)
// S.C: O(1)

class Solution {
    public boolean isThree(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt != n)
            return false; // n must be a perfect square

        // Check if sqrt is prime
        if (sqrt == 1)
            return false; // 1 is not prime
        for (int i = 2; i <= Math.sqrt(sqrt); i++) {
            if (sqrt % i == 0)
                return false;
        }
        return true;
    }
}

// Explanation:
// A number has exactly three divisors if and only if it is a perfect square of a prime number.
// Why?
// 1. If n = p^2 where p is prime, then the divisors of n are {1, p, p^2}, which are exactly three.
// 2. If n has more than one prime factor or is not a perfect square, it will have more than three divisors.