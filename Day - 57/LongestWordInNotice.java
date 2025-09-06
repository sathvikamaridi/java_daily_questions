public class LongestWordInNotice {

    public static String findLongestWord(String notice) {
        String[] words = notice.split(" ");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        // Test Case 01
        String notice1 = "Exam starts tomorrow";
        System.out.println("Longest word = \"" + findLongestWord(notice1) + "\"");
        // Output: tomorrow

        // Test Case 02
        String notice2 = "Placement training ongoing";
        System.out.println("Longest word = \"" + findLongestWord(notice2) + "\"");
        // Output: Placement

        // Test Case 03
        String notice3 = "cat dog bat";
        System.out.println("Longest word = \"" + findLongestWord(notice3) + "\"");
        // Output: cat
    }
}
