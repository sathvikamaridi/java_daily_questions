import java.util.*;

public class PreviousGreaterElement {
    
    public static int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack empty → no greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {10, 4, 2, 20, 40, 12, 30};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(findPGE(arr1)));

        // Test Case 2
        int[] arr2 = {3, 2, 1};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(findPGE(arr2)));
    }
}
