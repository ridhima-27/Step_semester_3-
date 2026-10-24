import java.util.Arrays;

public class FantasyScoreMultiplier {
    // applyMultipliers(...) must modify the caller's original array directly – it should return nothing at all[cite: 57].
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0; // Captain (2x points)[cite: 57]
        playerScores[viceCaptainIndex] *= 1.5; // Vice-Captain (1.5x points)[cite: 57]
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores)); // Output: [40.0, 110.0, 30.0, 93.0][cite: 57]
    }
}