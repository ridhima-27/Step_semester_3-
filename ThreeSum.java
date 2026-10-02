import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    
    public int[][] threeSum(int[] nums) {
        List<int[]> resultList = new ArrayList<>();
        
        // Sort the array first as a setup step[cite: 2]
        Arrays.sort(nums); 
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values to avoid reporting the same triplet[cite: 2]
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});
                    
                    // Skip duplicates for the second and third elements[cite: 2]
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return resultList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        
        // Sample Inputs[cite: 2]
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 0, 0};
        
        System.out.println("Output 1: " + Arrays.deepToString(solution.threeSum(nums1))); 
        // Expected: [[-1, -1, 2], [-1, 0, 1]][cite: 2]
        System.out.println("Output 2: " + Arrays.deepToString(solution.threeSum(nums2))); 
        // Expected: [[0, 0, 0]][cite: 2]
    }
}
