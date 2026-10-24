public class InPlaceReversal {
    public static void reverseArray(int[] arr) {
        int left = 0; // Use two pointers, one starting from the beginning[cite: 44]
        int right = arr.length - 1; // and one from the end of the array[cite: 44]
        
        while (left < right) {
            int temp = arr[left]; // Swap the elements at these pointers[cite: 44]
            arr[left] = arr[right];
            arr[right] = temp;
            left++; // Move them towards the center[cite: 44]
            right--;
        }
        System.out.println(java.util.Arrays.toString(arr));
    }
}