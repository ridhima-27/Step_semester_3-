public class DutyRoster {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] rotated = new String[n];
        k = k % n; // Remove full turns[cite: 38]
        
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i]; // Each name at index i moves to (i + k) % n[cite: 38]
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        String[] result = rotateRoster(names, 2);
        System.out.println(java.util.Arrays.toString(result)); // Expected Output: [D, E, A, B, C][cite: 38]
    }
}