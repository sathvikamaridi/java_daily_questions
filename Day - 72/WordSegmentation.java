import java.util.*;

public class WordSegmentation {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string is always segmentable

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        // Test Case 01
        String s1 = "pineapplepenapple";
        List<String> dict1 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println("Input: " + s1);
        System.out.println("Output: " + wordBreak(s1, dict1)); // true

        // Test Case 02
        String s2 = "catsandog";
        List<String> dict2 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Input: " + s2);
        System.out.println("Output: " + wordBreak(s2, dict2)); // false
    }
}
