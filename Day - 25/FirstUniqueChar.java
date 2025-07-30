import java.util.*;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Find first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No unique character found
    }

    public static void main(String[] args) {
        String s = "techstack";
        int index = firstUniqChar(s);
        if (index != -1) {
            System.out.println("First non-repeating character is '" + s.charAt(index) + "' at index " + index);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
