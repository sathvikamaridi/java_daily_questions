import java.util.*;

public class     {

    public static void findPairs(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<String> printed = new HashSet<>();
        boolean found = false;

        for (int num : arr) {
            int complement = target - num;

            if (seen.contains(complement)) {
                // Sort pair to avoid duplicates like (2,4) and (4,2)
                int first = Math.min(num, complement);
                int second = Math.max(num, complement);
                String pair = first + "," + second;

                if (!printed.contains(pair)) {
                    System.out.println("(" + first + ", " + second + ")");
                    printed.add(pair);
                    found = true;
                }
            }
            seen.add(num);
        }

        if (!found) {
            System.out.println("No pairs found with sum " + target);
        }
    }

    public static void main(String[] args) {
        // Test Case 01
        int[] arr1 = {2, 7, 4, -1, 5, 3};
        int target1 = 6;
        System.out.println("Pairs with sum " + target1 + " are:");
        findPairs(arr1, target1);

        // Test Case 02
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int target2 = 7;
        System.out.println("\nPairs with sum " + target2 + " are:");
        findPairs(arr2, target2);

        // Test Case 03
        int[] arr3 = {10, 20, 30, 40, 50};
        int target3 = 100;
        System.out.println("\nPairs with sum " + target3 + " are:");
        findPairs(arr3, target3);
    }
}
