import java.util.*;

public class SecondLargestDigit {
    
    public static int findSecondLargestDigit(int n) {
        Set<Integer> digits = new TreeSet<>();
        
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        
        if (digits.size() < 2) {
            return -1; // No second largest digit
        }
        
        // Convert to list to access elements
        List<Integer> digitList = new ArrayList<>(digits);
        return digitList.get(digitList.size() - 2);
    }

    public static void main(String[] args) {
        // Test Case 1
        int num1 = 983461;
        System.out.println("Input: " + num1);
        System.out.println("Output: " + findSecondLargestDigit(num1)); // 8

        // Test Case 2
        int num2 = 1111;
        System.out.println("Input: " + num2);
        System.out.println("Output: " + findSecondLargestDigit(num2)); // -1
    }
}
