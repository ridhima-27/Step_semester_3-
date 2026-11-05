
public class WarehouseBinGridScan {
    public static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxItems = -1;
        int maxRow = -1;
        int maxCol = -1;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxItems) {
                    maxItems = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        int[] result = warehouseSummary(grid);
        System.out.println("total = " + result[0] + ", maxCoordinate = (" + result[1] + ", " + result[2] + ")");
    }
}