public class SmallestSubarraySum {
    
    public static int smallestSubarray(int[] arr, int x) {
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;
        
        int start = 0, sum = 0;
        
        for (int end = 0; end < n; end++) {
            // Expand window
            sum += arr[end];
            
            // Shrink window while sum > x
            while (sum > x) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        // Test Case 01
        int[] arr1 = {1, 4, 45, 6, 10, 19};
        int x1 = 51;
        System.out.println("Smallest subarray length = " + smallestSubarray(arr1, x1));
        
        // Test Case 02
        int[] arr2 = {1, 10, 5, 2, 7};
        int x2 = 9;
        System.out.println("Smallest subarray length = " + smallestSubarray(arr2, x2));
    }
}
