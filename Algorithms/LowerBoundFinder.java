class LowerBoundFinder {
    public int lowerBound(int[] arr, int x) {
        int low = 0;                  // Start index
        int high = arr.length - 1;    // End index
        int ans = arr.length;         // Default value if not found

        while (low <= high) {
            int mid = (low + high) / 2;  // Find mid index

            if (arr[mid] >= x) {
                ans = mid;            // Store possible answer
                high = mid - 1;       // Move left
            } else {
                low = mid + 1;        // Move right
            }
        }
        return ans;  // Return the lower bound index
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};  // Sorted array
        int x = 9;                      // Target value

        LowerBoundFinder finder = new LowerBoundFinder();     // Create object
        int ind = finder.lowerBound(arr, x);                  // Find lower bound

        System.out.println("The lower bound is the index: " + ind);  // Print result
    }
}

// Lower Bound: smallest index such that arr[index] >= target(x)