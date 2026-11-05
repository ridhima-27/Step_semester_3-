import java.util.Arrays;

public class TheHeightLineUp {
    public static void lineUp(int[] heights) {
        boolean swapped;
        int pass = 1;
        do {
            swapped = false;
            for (int j = 0; j < heights.length - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;
        } while (swapped);
    }

    public static void main(String[] args) {
        int[] heights1 = {4, 2, 5, 1};
        int[] heights2 = {1, 3, 2, 4};
        
        System.out.println("Input 1:");
        lineUp(heights1);
        
        System.out.println("\nInput 2:");
        lineUp(heights2);
    }
}