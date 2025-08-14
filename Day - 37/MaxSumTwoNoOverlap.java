public class MaxSumTwoNoOverlap {
    public static int maxSumTwoNoOverlap(int[] nums, int L, int M) {
        return Math.max(helper(nums, L, M), helper(nums, M, L));
    }

    private static int helper(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        // Build prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int maxFirst = 0, result = 0;
        for (int i = firstLen + secondLen; i <= n; i++) {
            // Max sum for the first subarray before the second subarray
            maxFirst = Math.max(maxFirst, prefix[i - secondLen] - prefix[i - secondLen - firstLen]);

            // Sum of current second subarray
            int secondSum = prefix[i] - prefix[i - secondLen];

            result = Math.max(result, maxFirst + secondSum);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int L1 = 1, M1 = 2;
        System.out.println(maxSumTwoNoOverlap(nums1, L1, M1)); // Output: 20

        int[] nums2 = {3, 8, 1, 3, 2, 1, 8, 9, 0};
        int L2 = 3, M2 = 2;
        System.out.println(maxSumTwoNoOverlap(nums2, L2, M2)); // Output: 29
    }
}
