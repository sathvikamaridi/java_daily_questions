public class SumOfNaturalNumbers {

    // Method 1: Using formula: Sum = N * (N + 1) / 2
    public static int sumUsingFormula(int N) {
        if (N < 1) {
            System.out.println("Invalid input: N should be a positive natural number.");
            return 0;
        }
        return N * (N + 1) / 2;
    }

    // Method 2: Using loop (optional)
    public static int sumUsingLoop(int N) {
        if (N < 1) {
            System.out.println("Invalid input: N should be a positive natural number.");
            return 0;
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Test Case 1: N = 5
        int result1 = sumUsingFormula(5);
        System.out.println("Test Case 1 Output: " + result1);

        // Test Case 2: N = 6
        int result2 = sumUsingFormula(6);
        System.out.println("Test Case 2 Output: " + result2);

        // Optional: Test with loop method
        System.out.println("Sum using loop for N=5: " + sumUsingLoop(5));
        System.out.println("Sum using loop for N=6: " + sumUsingLoop(6));
    }
}
