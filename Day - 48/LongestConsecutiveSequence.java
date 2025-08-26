import java.util.*;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        
        for (int num : set) {
            // check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                longest = Math.max(longest, currentStreak);
            }
        }
        
        return longest;
    }

    public static void main(String[] args) {
        System.out.println("Test 01: " + longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
        System.out.println("Test 02: " + longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})); // 9
    }
}
