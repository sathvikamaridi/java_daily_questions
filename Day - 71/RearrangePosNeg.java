import java.util.*;

public class RearrangePosNeg {

    public static void rearrange(int[] arr) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        // Separate positives and negatives
        for (int num : arr) {
            if (num >= 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }

        int i = 0, p = 0, n = 0;

        // Merge alternately
        while (p < positives.size() && n < negatives.size()) {
            if (i % 2 == 0) {
                arr[i] = positives.get(p++);
            } else {
                arr[i] = negatives.get(n++);
            }
            i++;
        }

        // Append remaining positives
        while (p < positives.size()) {
            arr[i++] = positives.get(p++);
        }

        // Append remaining negatives
        while (n < negatives.size()) {
            arr[i++] = negatives.get(n++);
        }
    }

    public static void main(String[] args) {
        // Test Case 01
        int[] arr1 = {1, -2, 3, -4, -1, 4, 5, -6};
        rearrange(arr1);
        System.out.println("Output 1: " + Arrays.toString(arr1));

        // Test Case 02
        int[] arr2 = {-1, -2, -3, 4, 5, 6};
        rearrange(arr2);
        System.out.println("Output 2: " + Arrays.toString(arr2));
    }
}
