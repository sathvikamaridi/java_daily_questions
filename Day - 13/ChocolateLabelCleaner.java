import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ChocolateLabelCleaner {

    public static String removeDuplicateCharacters(String productName) {
        // Using LinkedHashSet to maintain insertion order and uniqueness
        Set<Character> seenCharacters = new LinkedHashSet<>();
        StringBuilder cleanedName = new StringBuilder();

        for (char ch : productName.toCharArray()) {
            if (!seenCharacters.contains(ch)) {
                seenCharacters.add(ch);
                cleanedName.append(ch);
            }
        }

        return cleanedName.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();

        // Process and Output
        String cleanedLabel = removeDuplicateCharacters(productName);
        System.out.println("Cleaned product label: " + cleanedLabel);

        scanner.close();
    }
}
