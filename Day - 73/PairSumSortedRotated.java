public class PairSumSortedRotated {

    public static void findPair(int[] arr, int target) {
        int n = arr.length;
        int pivot = -1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        int l = (pivot + 1) % n; // index of smallest element
        int r = pivot;           // index of largest element

        while (l != r) {
            int sum = arr[l] + arr[r];

            if (sum == target) {
                System.out.println("Pair Found: (" + arr[l] + ", " + arr[r] + ")");
                return;
            }

            if (sum < target)
                l = (l + 1) % n; // move forward circularly
            else
                r = (n + r - 1) % n; // move backward circularly
        }

        System.out.println("No pair found");
    }

    public static void main(String[] args) {
        // Test Case 01
        int[] arr1 = {11, 15, 6, 8, 9, 10};
        int target1 = 16;
        findPair(arr1, target1); // Pair Found: (6, 10)

        // Test Case 02
        int[] arr2 = {4, 5, 6, 7, 1, 2, 3};
        int target2 = 9;
        findPair(arr2, target2); // Pair Found: (6, 3)
    }
}
