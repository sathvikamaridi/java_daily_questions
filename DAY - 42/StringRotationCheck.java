public class StringRotationCheck {
    // Function to check if s2 is a rotation of s1
    public static boolean isRotation(String s1, String s2) {
        // Step 1: Check length
        if (s1.length() != s2.length()) {
            return false;
        }
        
        // Step 2: Concatenate s1 with itself
        String temp = s1 + s1;
        
        // Step 3: Check if s2 is a substring of temp
        return temp.contains(s2);
    }

    public static void main(String[] args) {
        // Test Case 01
        String s1 = "ABCD", s2 = "CDAB";
        System.out.println(isRotation(s1, s2)); // Output: true

        // Test Case 02
        s1 = "ABCD"; 
        s2 = "ACBD";
        System.out.println(isRotation(s1, s2)); // Output: false
    }
}
