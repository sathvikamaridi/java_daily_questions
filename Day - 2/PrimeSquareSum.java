public class PrimeSquareSum {

    // Helper method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    // Method to calculate the sum of squares of primes between M and N
    public static int sumOfPrimeSquares(int M, int N) {
        if (M > N) {
            System.out.println("Invalid range: M should be less than or equal to N.");
            return 0;
        }

        int sum = 0;
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sum += i * i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Test Case 01: M = 2, N = 10 => Primes = 2, 3, 5, 7 => Squares = 4 + 9 + 25 + 49 = 87
        System.out.println("Test Case 01 Output: " + sumOfPrimeSquares(2, 10));

        // Test Case 02: M = 11, N = 20 => Primes = 11, 13, 17, 19 => Squares = 121 + 169 + 289 + 361 = 940
        System.out.println("Test Case 02 Output: " + sumOfPrimeSquares(11, 20));

        // Test Case 03: M = 4, N = 4 => No primes => Output = 0
        System.out.println("Test Case 03 Output: " + sumOfPrimeSquares(4, 4));

        // Test Case 04: M = 12, N = 8 => Invalid range => Output = 0
        System.out.println("Test Case 04 Output: " + sumOfPrimeSquares(12, 8));
    }
}
