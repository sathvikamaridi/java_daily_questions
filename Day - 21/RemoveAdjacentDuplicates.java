import java.util.Stack;

public class RemoveAdjacentDuplicates {

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "abbaca";
        String output = removeDuplicates(input);
        System.out.println("Final String after removing adjacent duplicates: " + output);
    }
}
