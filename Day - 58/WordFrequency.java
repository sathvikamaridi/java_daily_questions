import java.util.*;

public class WordFrequency {
    public static void wordFrequency(String paragraph) {
        String[] words = paragraph.split(" ");
        Map<String, Integer> freq = new LinkedHashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Case 01:");
        wordFrequency("Java is great and Java is powerful");

        System.out.println("\nTest Case 02:");
        wordFrequency("One one ONE oNe");
    }
}
