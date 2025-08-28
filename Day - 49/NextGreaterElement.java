import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Default to -1
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 2, 25};
        int[] result1 = nextGreaterElements(arr1);
        System.out.println(Arrays.toString(result1)); // [5, 25, 25, -1]

        int[] arr2 = {13, 7, 6, 12};
        int[] result2 = nextGreaterElements(arr2);
        System.out.println(Arrays.toString(result2)); // [-1, 12, 12, -1]
    }
}
