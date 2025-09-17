import java.util.*;

public class NextGreaterFrequencyElement {
    public static int[] nextGreaterFrequency(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();

        // count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>(); // will store indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && freq.get(arr[stack.peek()]) < freq.get(arr[i])) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 3, 4, 2, 1};
        System.out.println("Output: " + Arrays.toString(nextGreaterFrequency(arr1)));
        // Expected: [-1, -1, 1, 2, 2, 1, -1]

        int[] arr2 = {4, 4, 5, 2, 5, 5, 4};
        System.out.println("Output: " + Arrays.toString(nextGreaterFrequency(arr2)));
        // Expected: [-1, -1, -1, 5, -1, -1, -1]
    }
}
