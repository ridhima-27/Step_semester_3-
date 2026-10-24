import java.util.Arrays;

public class Top3Podium {
    static int[] findTopThreeScores(int[] scores) {
        // Keep three running variables - first, second, third[cite: 63].
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        // Find the top 3 scores in a single pass through the array[cite: 63].
        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }
        return new int[]{first, second, third}; // Return the three scores in descending order[cite: 63].
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(Arrays.toString(findTopThreeScores(scores))); // Output: [90, 90, 82][cite: 63]
    }
}