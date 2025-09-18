import java.util.*;

public class LongestDuplicateSubstring {

    // Function to build suffix array
    private static int[] buildSuffixArray(String s) {
        int n = s.length();
        String[] suffixes = new String[n];
        int[] suffixArr = new int[n];

        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i);
        }

        Arrays.sort(suffixes);

        for (int i = 0; i < n; i++) {
            suffixArr[i] = n - suffixes[i].length();
        }

        return suffixArr;
    }

    // Function to find LCP between two strings
    private static int lcp(String s, int i, int j) {
        int n = s.length();
        int length = 0;
        while (i < n && j < n && s.charAt(i) == s.charAt(j)) {
            i++;
            j++;
            length++;
        }
        return length;
    }

    // Main function to find longest duplicate substring
    public static String longestDupSubstring(String s) {
        int n = s.length();
        if (n == 0) return "";

        int[] suffixArr = buildSuffixArray(s);
        String result = "";
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            int len = lcp(s, suffixArr[i], suffixArr[i - 1]);
            if (len > maxLen) {
                maxLen = len;
                result = s.substring(suffixArr[i], suffixArr[i] + len);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 01
        String s1 = "banana";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + longestDupSubstring(s1));

        // Test Case 02
        String s2 = "abcd";
        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + longestDupSubstring(s2));

        // Test Case 03
        String s3 = "mississippi";
        System.out.println("\nInput: " + s3);
        System.out.println("Output: " + longestDupSubstring(s3));
    }
}
