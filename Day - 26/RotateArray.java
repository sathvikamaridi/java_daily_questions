import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle k greater than length
        reverse(nums, 0, n - 1);       // Reverse the whole array
        reverse(nums, 0, k - 1);       // Reverse first k elements
        reverse(nums, k, n - 1);       // Reverse the remaining elements
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        // Output: [5, 6, 7, 1, 2, 3, 4]
    }
}
