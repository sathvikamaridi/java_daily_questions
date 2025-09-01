public class LongestDuplicateSubstring {

    public static String longestDupSubstring(String s) {
        int n = s.length();
        String result = "";
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                
                if (sub.length() > result.length() && s.indexOf(sub, i + 1) != -1) {
                    result = sub;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String s1 = "banana";
        System.out.println("Input: " + s1 + " -> Output: " + longestDupSubstring(s1));

        String s2 = "abcdef";
        System.out.println("Input: " + s2 + " -> Output: " + longestDupSubstring(s2));

        String s3 = "ababa";
        System.out.println("Input: " + s3 + " -> Output: " + longestDupSubstring(s3));
    }
}
