public class MaximumSubarray {
    
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide to extend or start fresh based on which gives a larger sum[cite: 1]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        
        // Sample Inputs
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-3, -1, -2};
        
        System.out.println("Output 1: " + solution.maxSubArray(nums1)); // Expected: 6[cite: 2]
        System.out.println("Output 2: " + solution.maxSubArray(nums2)); // Expected: -1[cite: 2]
    }
}