import java.util.Arrays;

// Player must implement Comparable<Player> so that Arrays.sort(...) alone can rank the draftable array[cite: 61].
class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    @Override
    public int compareTo(Player other) {
        // rank the draftable array by fantasy points (batting average), descending[cite: 61]
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class AutoDraftEngine {
    // Provide two overloaded isDraftable(...) checks[cite: 61].
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10; // A player with a long track record qualifies on experience alone[cite: 61].
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured; // a newer player still needs to be both reasonably experienced and currently fit[cite: 61].
    }

    static String draftAndRank(Player[] players) {
        Player[] draftableTemp = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            boolean eligible = isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured);
            if (eligible) {
                draftableTemp[count++] = p;
            }
        }

        Player[] drafted = Arrays.copyOf(draftableTemp, count);
        Arrays.sort(drafted); // Arrays.sort(...) alone can rank the draftable array[cite: 61].

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < drafted.length; i++) {
            result.append(i + 1).append(". ").append(drafted[i].name);
            if (i < drafted.length - 1) result.append(" | ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players)); 
        // Output: 1. Rahul | 2. Virat | 3. Dev[cite: 61]
    }
}