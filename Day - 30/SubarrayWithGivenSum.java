import java.util.*;

public class SubarrayWithGivenSum {
    public static void findSubarrays(int[] arr, int target) {
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            int currentSum = 0;
            List<Integer> subarray = new ArrayList<>();

            for (int end = start; end < n; end++) {
                currentSum += arr[end];
                subarray.add(arr[end]);

                if (currentSum == target) {
                    System.out.println(subarray);
                    break; // Remove break if you want to include overlapping subarrays
                }

                if (currentSum > target) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 9;

        System.out.println("Subarrays with sum " + target + ":");
        findSubarrays(arr, target);
    }
}
