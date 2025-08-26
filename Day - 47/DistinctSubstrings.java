import java.util.*;

public class DistinctSubstrings {
    public static int countDistinctSubstrings(String s) {
        Set<String> substrings = new HashSet<>();
        
        // Generate all substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        
        return substrings.size();
    }

    public static void main(String[] args) {
        System.out.println("Test 01: " + countDistinctSubstrings("ababa")); // 9
        System.out.println("Test 02: " + countDistinctSubstrings("aaa"));   // 3
    }
}

