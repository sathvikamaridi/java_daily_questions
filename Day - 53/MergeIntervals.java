import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];
            int lastEnd = current[1];

            // Step 2: Check overlap
            if (currStart <= lastEnd) {
                current[1] = Math.max(lastEnd, currEnd);
            } else {
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        // Test Case 01
        int[][] arr1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(arr1)));
        // Expected: [[1,6],[8,10],[15,18]]

        // Test Case 02
        int[][] arr2 = {{1,4},{4,5}};
        System.out.println(Arrays.deepToString(merge(arr2)));
        // Expected: [[1,5]]
    }
}
