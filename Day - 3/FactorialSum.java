public class FactorialSum {

    // Method to calculate factorial of a number
    public static long factorial(int num) {
        if (num == 0 || num == 1) return 1;
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to calculate sum of factorials between M and N
    public static long sumOfFactorials(int M, int N) {
        if (M > N) {
            System.out.println("Invalid range: M should be less than or equal to N.");
            return 0;
        }

        long sum = 0;
        for (int i = M; i <= N; i++) {
            sum += factorial(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        // Test Case 01: M = 3, N = 5 => 3! + 4! + 5! = 6 + 24 + 120 = 150
        System.out.println("Test Case 01 Output: " + sumOfFactorials(3, 5));

        // Test Case 02: M = 0, N = 4 => 0! + 1! + 2! + 3! + 4! = 1 + 1 + 2 + 6 + 24 = 34
        System.out.println("Test Case 02 Output: " + sumOfFactorials(0, 4));

        // Test Case 03: M = 5, N = 5 => 5! = 120
        System.out.println("Test Case 03 Output: " + sumOfFactorials(5, 5));

        // Test Case 04: M = 6, N = 4 => Invalid range => Output = 0
        System.out.println("Test Case 04 Output: " + sumOfFactorials(6, 4));
    }
}
