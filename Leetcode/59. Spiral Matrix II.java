class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;

        int top = 0;
        int down = n - 1;
        int counter = 1;
        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res[top][i] = counter;
                counter++;
            }
            top++;

            for (int i = top; i <= down; i++) {
                res[i][right] = counter;
                counter++;
            }
            right--;

            if (top <= down) {
                for (int i = right; i >= left; i--) {
                    res[down][i] = counter;
                    counter++;
                }
                down--;
            }

            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    res[i][left] = counter;
                    counter++;
                }
                left++;
            }

        }
        return res;

    }
}