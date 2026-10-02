public class FindMinimum {
    
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Compare the middle element to the rightmost element to decide which half to search[cite: 3]
            if (nums[mid] > nums[right]) {
                // Minimum must be hiding in the right half[cite: 3]
                left = mid + 1;
            } else {
                // Minimum is in the left half, or is the mid element
                right = mid;
            }
        }
        
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimum solution = new FindMinimum();
        
        // Sample Inputs[cite: 4]
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};
        
        System.out.println("Output 1: " + solution.findMin(nums1)); // Expected: 1[cite: 4]
        System.out.println("Output 2: " + solution.findMin(nums2)); // Expected: 0[cite: 4]
        System.out.println("Output 3: " + solution.findMin(nums3)); // Expected: 11[cite: 4]
    }
}
