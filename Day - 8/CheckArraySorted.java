public class CheckArraySorted {

    // Function to check if array is sorted in ascending order
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Function to display result
    public static void checkAndDisplay(int[] arr) {
        if (isSorted(arr)) {
            System.out.println("Output: Sorted");
        } else {
            System.out.println("Output: Not Sorted");
        }
    }

    public static void main(String[] args) {
        // Test Case 01
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.print("Test Case 01: ");
        checkAndDisplay(arr1);

        // Test Case 02
        int[] arr2 = {1, 2, 2, 3, 4};
        System.out.print("Test Case 02: ");
        checkAndDisplay(arr2);

        // Test Case 03
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.print("Test Case 03: ");
        checkAndDisplay(arr3);
    }
}
