import java.util.Arrays;

public class TheDiceThrowTally {
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7]; 
        
        for (int roll : rolls) {
            count[roll]++;
        }
        
        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i] + " ");
        }
        System.out.println();
        
        int[] sortedRolls = new int[rolls.length];
        int index = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++) {
                sortedRolls[index++] = i;
            }
        }
        
        System.out.println("Sorted: " + Arrays.toString(sortedRolls));
        return sortedRolls;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        diceSort(rolls);
    }
}