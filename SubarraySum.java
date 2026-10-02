import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    
    public int subarraySum(int[] nums, int k) {
        // Hash map of prefix-sum frequencies[cite: 3]
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Careful initialization of the "empty prefix" base case[cite: 3]
        prefixSumMap.put(0, 1); 
        
        int count = 0;
        int currentSum = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Check how many earlier prefix sums equal (currentSum - k)[cite: 3]
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        SubarraySum solution = new SubarraySum();
        
        // Sample Inputs[cite: 3]
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {1, -1, 0};
        
        System.out.println("Output 1: " + solution.subarraySum(nums1, 2)); // Expected: 2[cite: 3]
        System.out.println("Output 2: " + solution.subarraySum(nums2, 0)); // Expected: 3[cite: 3]
    }
}