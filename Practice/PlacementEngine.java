import java.util.Arrays;

// Candidate must implement Comparable<Candidate>[cite: 64]
class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;
    double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        // Calculation required to match example output: 102.0, 100.5, 85.0[cite: 65]
        this.compositeScore = (cgpa * 10) + (codingScore / 2.0); 
    }

    @Override
    public int compareTo(Candidate other) {
        // rank a shortlisted array by composite score, descending[cite: 64]
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}

public class PlacementEngine {
    // Provide two overloaded isEligible(...) checks[cite: 64].
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0; // a strong CGPA alone is enough[cite: 64].
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60; // a borderline CGPA can still qualify through a genuinely good coding-test score[cite: 64].
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] temp = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                temp[count++] = c;
            }
        }

        Candidate[] shortlisted = Arrays.copyOf(temp, count);
        Arrays.sort(shortlisted); // Arrays.sort(...) alone can rank a shortlisted array[cite: 64].

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ").append(shortlisted[i].name)
                  .append(" (").append(shortlisted[i].compositeScore).append(")");
            if (i < shortlisted.length - 1) result.append(" | ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates)); 
        // Output: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)[cite: 65]
    }
}