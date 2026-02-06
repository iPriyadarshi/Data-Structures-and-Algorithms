class Solution {
    public boolean isArmstrong(int n) {
        int count = countDigit(n);
        int sum = 0;
        int copy = n;

        while (n > 0) {
            int lastDigit = n % 10;
            sum += Math.pow(lastDigit, count);
            n = n / 10;
        }

        return (sum == copy);
    }

    private int countDigit(int n) {
        int count = (int) (Math.log10(n) + 1);
        return count;
    }
}
