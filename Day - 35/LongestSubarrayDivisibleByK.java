import java.util.*;

public class LongestSubarrayDivisibleByK {
    public static int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1); // base case

        int prefixSum = 0, maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = ((prefixSum % k) + k) % k; // handle negatives

            if (remainderIndexMap.containsKey(remainder)) {
                int prevIndex = remainderIndexMap.get(remainder);
                int length = i - prevIndex;

                // Ensure subarray is not the entire array
                if (length < nums.length) {
                    maxLength = Math.max(maxLength, length);
                }
            } else {
                remainderIndexMap.put(remainder, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, -2, 2, -4, 6, 8, 3};
        int k1 = 4;
        System.out.println(longestSubarray(nums1, k1)); // Output: 5

        int[] nums2 = {5, 0, 2, -2, 1, 6};
        int k2 = 3;
        System.out.println(longestSubarray(nums2, k2)); // Output: 4
    }
}
