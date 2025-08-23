public class UniqueCharacters {
    public static boolean hasUniqueChars(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasUniqueChars("abcdef")); // true
        System.out.println(hasUniqueChars("hello"));  // false
        System.out.println(hasUniqueChars(""));       // true
        System.out.println(hasUniqueChars("aA"));     // true
    }
}
