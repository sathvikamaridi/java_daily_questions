
public class SubarraySum {
    public static void findSubarrays(int[] arr, int K) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == K) {
                    // Print subarray
                    System.out.print("[");
                    for (int x = i; x <= j; x++) {
                        System.out.print(arr[x]);
                        if (x < j) System.out.print(",");
                    }
                    System.out.println("]");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 2};
        int K1 = 6;
        System.out.println("Test Case 1:");
        findSubarrays(arr1, K1);

        int[] arr2 = {3, 4, 7, 2, -3, 1, 4, 2};
        int K2 = 7;
        System.out.println("Test Case 2:");
        findSubarrays(arr2, K2);
    }
}
