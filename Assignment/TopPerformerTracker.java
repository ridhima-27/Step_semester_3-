public class TopPerformerTracker {
    static String findMinMaxSpread(int[] scores) {
        if (scores.length == 0) return "";
        int min = scores[0];
        int max = scores[0];

        // find the minimum and maximum in a single pass through the array[cite: 59].
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        int spread = max - min;
        // Report the minimum, the maximum, and the spread (max - min) together[cite: 59].
        return "Min: " + min + " Max: " + max + " Spread: " + spread;
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores)); // Output: Min: 33 Max: 90 Spread: 57[cite: 59]
    }
}