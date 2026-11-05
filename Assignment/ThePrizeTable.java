import java.util.Arrays;

public class ThePrizeTable {
    public static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        System.out.println(Arrays.toString(marks));
        return swaps;
    }

    public static void main(String[] args) {
        int[] marks1 = {45, 90, 60, 75};
        int[] marks2 = {80, 70, 60};
        
        System.out.println("swaps = " + prizeTable(marks1));
        System.out.println("swaps = " + prizeTable(marks2));
    }
}