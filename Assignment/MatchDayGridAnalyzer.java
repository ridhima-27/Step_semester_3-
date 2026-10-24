public class MatchDayGridAnalyzer {
    // Write a private helper, rowAverage(int[] row), and call it once per match[cite: 60].
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;
        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            // A match averaging at or above the threshold is a "Power Surge"; below it, "Normal"[cite: 60].
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";
            result.append("Match ").append(i).append(": ").append(classification);
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runs = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println(classifyMatches(runs, 8)); 
        // Output: Match 0: Normal | Match 1: Power Surge | Match 2: Normal[cite: 60]
    }
}