public class OddProductCalculator {

    public static long productOfOdds(int M, int N) {
        if (M > N) {
            System.out.println("Invalid range: M should be less than or equal to N.");
            return 1;
        }

        long product = 1;
        boolean hasOdd = false;

        for (int i = M; i <= N; i++) {
            if (i % 2 != 0) {
                product *= i;
                hasOdd = true;
            }
        }

        return hasOdd ? product : 1;  // Return 1 if no odd numbers found
    }

    public static void main(String[] args) {
        // Test Case 1: M = 3, N = 7
        System.out.println("Test Case 1 Output: " + productOfOdds(3, 7));

        // Test Case 2: M = 2, N = 5
        System.out.println("Test Case 2 Output: " + productOfOdds(2, 5));

        // Test Case 3: M = 10, N = 6 (Invalid Range)
        System.out.println("Test Case 3 Output: " + productOfOdds(10, 6));
    }
}
