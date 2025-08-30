public class StringRotationCheck {
    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        String combined = s1 + s1;
        return combined.contains(s2);
    }

    public static void main(String[] args) {
        String[][] testCases = {
            {"waterbottle", "erbottlewat"}, // true
            {"hello", "llohe"},             // true
            {"abc", "acb"},                 // false
            {"abc$123", "123abc$"},         // true
            {"coding", "coding"}            // true
        };

        for (String[] testCase : testCases) {
            System.out.println(
                "s1: " + testCase[0] + ", s2: " + testCase[1] +
                " -> " + isRotation(testCase[0], testCase[1])
            );
        }
    }
}
