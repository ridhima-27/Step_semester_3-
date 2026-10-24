public class DuplicatePlayerChecker {
    static String findDuplicatePick(String[] playerNames) {
        // Compare every name against every other name using plain nested loops[cite: 58].
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i]; // Report the first duplicate found[cite: 58].
                }
            }
        }
        return "No Duplicates Found"; // if none exist, say so clearly[cite: 58].
    }

    public static void main(String[] args) {
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(lineup1)); // Output: Duplicate Found: Kohli[cite: 58]
    }
}