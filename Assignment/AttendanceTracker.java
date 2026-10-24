public class AttendanceTracker {
    public static void attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;
        
        for (int day : days) {
            if (day == 1) {
                present++; // Grows on every 1[cite: 40]
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak); // Remember the largest value[cite: 40]
            } else {
                currentStreak = 0; // Resets to 0 on every 0[cite: 40]
            }
        }
        System.out.println("Present: " + present + ", Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        int[] days = {1, 1, 0, 1, 1, 1, 0, 1};
        attendanceSummary(days); // Expected Output: Present: 6, Longest streak: 3[cite: 40]
    }
}