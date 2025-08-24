import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Approach-1 (Using frequency array)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
         * Time Complexity: O(n + m) where n and m are lengths of nums1 and nums2
         * Space Complexity: O(1) since frequency array has fixed size 1001
         */
        int[] freq = new int[1001];

        for (int num : nums1) {
            freq[num]++;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (freq[num] > 0) {
                result.add(num);
                freq[num]--;
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}

// Approach-2 (Using sorting and 2-Pointers)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
         * Time Complexity: O(nlogn + mlogm) where n and m are lengths of nums1 and
         * nums2 (due to sorting)
         * Space Complexity: O(1) if we don't count the space used for output array
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] arr = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            arr[k] = result.get(k);
        }

        return arr;
    }
}

// Approach-3 (Using map)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
         * Time Complexity: O(n + m) where n and m are lengths of nums1 and nums2
         * Space Complexity: O(min(n, m)) to store the HashMap
         */
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}
