public class ExamScoreBand {
    public static int countInBand(int[] scores, int low, int high) {
        int leftBound = findFirstGreaterOrEqual(scores, low);
        int rightBound = findFirstGreater(scores, high);
        return rightBound - leftBound; // The answer is the difference[cite: 39]
    }
    
    private static int findFirstGreaterOrEqual(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    private static int findFirstGreater(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58)); // Expected Output: 6[cite: 39]
    }
}