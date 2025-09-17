import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // remove adjacent duplicate
            } else {
                stack.push(c);
            }
        }

        // build result from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test Case 01: " + removeDuplicates("abbaca")); // "ca"
        System.out.println("Test Case 02: " + removeDuplicates("azxxzy")); // "ay"
        System.out.println("Test Case 03: " + removeDuplicates("aabbcc")); // ""
    }
}
