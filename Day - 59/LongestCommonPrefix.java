public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println("Test Case 01: " + longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println("Test Case 02: " + longestCommonPrefix(new String[]{"","",""}));
        System.out.println("Test Case 03: " + longestCommonPrefix(new String[]{"hello"}));
    }
}
