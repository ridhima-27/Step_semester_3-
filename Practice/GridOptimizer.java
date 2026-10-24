public class GridOptimizer {
    // Write a private helper, rowAverage(int[] row), and call it once per row[cite: 64].
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;
        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            // A row averaging below the threshold is a "Quiet Zone"; at or above it, a "Buzzing Zone"[cite: 64].
            String classification = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";
            result.append("Row ").append(i).append(": ").append(classification);
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seating = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(seating, 60)); 
        // Output: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone[cite: 64]
    }
}