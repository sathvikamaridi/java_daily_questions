import java.util.HashSet;

public class RemoveDuplicates {

    public static String removeDuplicates(String trainCode) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char ch : trainCode.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test Case 01
        String trainCode1 = "EXPRESS";
        System.out.println(removeDuplicates(trainCode1)); // Output: EXPRES

        // Test Case 02
        String trainCode2 = "RAILWAY123RAIL";
        System.out.println(removeDuplicates(trainCode2)); // Output: RAILWY123
    }
}
