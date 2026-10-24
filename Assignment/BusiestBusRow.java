public class BusiestBusRow {
    public static void busiestRow(int[][] grid) {
        int bestRow = -1;
        int maxSum = -1;
        
        for (int i = 0; i < grid.length; i++) { // Outer loop for the rows[cite: 41]
            int currentSum = 0;
            for (int j = 0; j < grid[i].length; j++) { // Inner loop to add up the seats[cite: 41]
                currentSum += grid[i][j];
            }
            if (currentSum > maxSum) { // Update the best row only when a total is strictly larger[cite: 41]
                maxSum = currentSum;
                bestRow = i;
            }
        }
        System.out.println("Row " + bestRow + ", Total " + maxSum);
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 0, 1}, {3, 3, 1}, {1, 1, 1}};
        busiestRow(grid); // Expected Output: Row 1, Total 7[cite: 41]
    }
}