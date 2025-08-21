import java.util.Arrays;
// import java.util.Collections;

public class Sorting {
    // Bubble Sort
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Optimized Bubble Sort
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void optimizedBubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    // Selection Sort
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static void insertionSort(int[] arr) {
        // Pick an element from unsorted part and place it in the correct position in
        // sorted part
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // Insert arr[i] into the sorted sequence arr[0..i-1]
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Inbuilt Sorting
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    public static void inbuiltSort(int[] arr) {
        Arrays.sort(arr);
        // Arrays.sort(arr,startIndex,endIndex), endIndex is exclusive

        // Arrays.sort(arr, Collections.reverseOrder()); ---> To use reverseOrder()
        // change {inbuiltSort(int[] arr)} to {inbuiltSort(Integer[] arr)} as
        // reverseOrder() only works with objects
        // Ex: Integer arr[] = {5, 2, 8, 1, 3};

        // Arrays.sort(arr, startIndex, endIndex, Collections.reverseOrder());
    }

    // Merge Sort
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Counting Sort
    // Time Complexity: O(n + k)
    // Space Complexity: O(k)
    public static void countingSort(int[] arr) {
        // Used when range:=(max-min) of input is known and limited
        // Used for sorting integers
        if (arr.length == 0) {
            return;
        }
        // Find the maximum and minimum elements in the array
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // Create a count array of size (max - min + 1) --- frequency array
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        // Modify the original array using the count array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index] = i + min;
                index++;
                count[i]--;
            }
        }
    }

    // Radix Sort
    // Time Complexity: O(d * (n + k)), where d is the number of digits in the
    // maximum
    // Space Complexity: O(k)
    public static void radixSort(int[] arr) {
        // Find the maximum number to know the number of digits
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Since we're dealing with base 10
        // Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        // Modify count array to get positions
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        // Copy the output array to arr
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Quick Sort
    // Time Complexity: O(n log n) on average, O(n^2) in the worst case
    // Space Complexity: O(log n) due to recursion stack
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}