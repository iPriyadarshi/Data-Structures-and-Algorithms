class UpperBoundFinder {
    public int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;  // Default to length if not found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                ans = mid;        // Store current index as potential answer
                high = mid - 1;   // Move left
            } else {
                low = mid + 1;    // Move right
            }
        }
        return ans;  // Return final answer
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};  // Sorted array
        int x = 9;

        UpperBoundFinder finder = new UpperBoundFinder();
        int ind = finder.upperBound(arr, x);  // Call method

        System.out.println("The upper bound is the index: " + ind);
    }
}

// Upper Bound: smallest index such that arr[index] > target(x)
