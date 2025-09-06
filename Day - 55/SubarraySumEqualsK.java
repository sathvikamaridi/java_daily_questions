import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Initialize with sum = 0 having one frequency
        freq.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            // Check if (prefixSum - k) exists in map
            if (freq.containsKey(prefixSum - k)) {
                count += freq.get(prefixSum - k);
            }

            // Update frequency of prefixSum
            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test Case 01
        int[] nums1 = {1, 2, 3, -2, 5};
        int k1 = 3;
        System.out.println(subarraySum(nums1, k1)); // Output: 3

        // Test Case 02
        int[] nums2 = {1, 1, 1};
        int k2 = 2;
        System.out.println(subarraySum(nums2, k2)); // Output: 2

        // Test Case 03
        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;
        System.out.println(subarraySum(nums3, k3)); // Output: 4
    }
}
