import java.util.Arrays;

public class Product {
    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Forward pass: accumulate the product of elements to the left
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Backward pass: multiply by the product of elements to the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
    }

    // The main method acts as the entry point to run the program
    public static void main(String[] args) {
        Product solution = new Product();
        
        // Sample Input
        int[] nums = {1, 2, 3, 4};
        
        // Call the method and store the result
        int[] result = solution.productExceptSelf(nums);
        
        // Print the result to the console
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
    }
}