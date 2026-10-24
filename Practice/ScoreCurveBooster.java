import java.util.Arrays;

public class ScoreCurveBooster {
    // curveScores(...) must modify the caller's original array directly - it should return nothing at all.
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        // Use Arrays.toString(...) to print the final leaderboard[cite: 62].
        System.out.println(Arrays.toString(scores)); // Output: [80, 95, 70][cite: 62]
    }
}
