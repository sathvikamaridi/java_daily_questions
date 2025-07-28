import java.util.*;

public class NextGreaterElement {

    public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are smaller or equal to current
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element onto stack
            stack.push(arr[i]);
        }

        return result;
    }

    // Utility to print array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int[] result = findNextGreaterElements(arr);

        System.out.println("Next Greater Elements:");
        printArray(result); // Output: 5 25 25 -1
    }
}
