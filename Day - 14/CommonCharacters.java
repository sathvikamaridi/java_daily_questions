import java.util.*;

public class CommonCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from Terminal A
        System.out.print("Enter Terminal A city name:\n");
        String cityA = scanner.nextLine().toLowerCase();

        // Input from Terminal B
        System.out.print("Enter Terminal B city name:\n");
        String cityB = scanner.nextLine().toLowerCase();

        // Use Sets to store unique characters
        Set<Character> setA = new HashSet<>();
        Set<Character> commonChars = new TreeSet<>();

        // Add all characters from cityA to setA
        for (char ch : cityA.toCharArray()) {
            if (Character.isLetter(ch)) {
                setA.add(ch);
            }
        }

        // Check which characters in cityB are also in setA
        for (char ch : cityB.toCharArray()) {
            if (Character.isLetter(ch) && setA.contains(ch)) {
                commonChars.add(ch);
            }
        }

        // Output result
        if (commonChars.isEmpty()) {
            System.out.println("No common characters");
        } else {
            System.out.println("Common characters: " + commonChars);
        }

        scanner.close();
    }
}
