public class DuplicateTeamFinder {
    static String findDuplicateTeam(String[] teamNames) {
        // Compare every name against every other name using plain nested loops[cite: 62].
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i]; // Report the first duplicate found[cite: 62].
                }
            }
        }
        return "No Duplicates Found"; // if none exist, say so clearly[cite: 62].
    }

    public static void main(String[] args) {
        String[] teams = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teams)); // Output: Duplicate Found: ByteForce[cite: 62]
    }
}