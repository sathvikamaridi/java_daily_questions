import java.util.*;

public class SeparateEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read input size
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Step 2: Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Step 3: Separate into even and odd lists
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int num : arr) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        // Step 4: Print results
        System.out.print("Even elements: ");
        for (int num : even) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Odd elements: ");
        for (int num : odd) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
    }
}
