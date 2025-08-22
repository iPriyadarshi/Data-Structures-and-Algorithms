public class Searching {
    // Searching in 1D array

    // Time Complexity: O((n), where n is the length of array
    // Space Complexity: O(1)
    public static void linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Element not found in the array.");
    }

    // Time Complexity: O(log n), where n is the length of the array
    // Space Complexity: O(1)
    public static void binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                System.out.println("Element found at index: " + mid);
                return;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Element not found in the array.");
    }

    // Searching in 2D array

    // Time Complexity: O(n*m), where n is the number of rows and m is the number of columns
    // Space Complexity: O(1)
    public static void linearSearch(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == target) {
                    System.out.println("Element found at index: (" + i + "," + j + ")");
                    return;
                }
            }
        }
        System.out.println("Element not found in the array.");
    }

    // Time Complexity: O(n + m), where n is the number of rows and m is the number of columns
    // Space Complexity: O(1)
    public static void binarySearch(int[][] arr, int target) {
        // This algorithm is also known as "Staircase Search" or "Step-wise Search". It
        // gets this name because the search pattern looks like moving down a staircase:

        // 1. Starting from the top-right corner
        // 2. Moving either left (when current > target) or down (when current < target)

        // This algorithm works specifically on 2D arrays that are sorted both row-wise
        // and column-wise, where:
        // - Each row is sorted from left to right
        // - Each column is sorted from top to bottom

        int row = 0;
        int col = arr[0].length - 1;

        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                System.out.println("Element found at index: (" + row + "," + col + ")");
                return;
            } else if (arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Element not found in the array.");
    }

}
