import java.util.HashMap;

public class LongestZeroSumSubarray {
    
    public static int longestZeroSumSubarrayLength(int[] nums) {
        // Map to store prefix sum and its earliest index
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // If sum == 0, update maxLength
            if (sum == 0) {
                maxLength = i + 1;
            }

            // If this sum has been seen before
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);  // Store the first occurrence of this sum
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, -3, 3, -1, 2, -2};

        int result = longestZeroSumSubarrayLength(input);
        System.out.println("Length of the longest subarray with sum 0: " + result);
    }
}
