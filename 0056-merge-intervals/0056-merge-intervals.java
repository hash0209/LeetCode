class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int index = 0; // index of last merged interval

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                // Overlap, merge intervals
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                // No overlap, move index forward
                index++;
                intervals[index] = intervals[i];
            }
        }

        // Copy only the merged portion
        return Arrays.copyOfRange(intervals, 0, index + 1);
    }
}