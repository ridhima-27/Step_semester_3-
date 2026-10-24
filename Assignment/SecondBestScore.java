public class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1; // Keep two variables, highest and second[cite: 42]
        int second = -1;
        
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score > second && score != highest) { // Skip a score that equals the current highest[cite: 42]
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] scores = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(scores)); // Expected Output: 78[cite: 42]
    }
}