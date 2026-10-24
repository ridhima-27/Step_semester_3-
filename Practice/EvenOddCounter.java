public class EvenOddCounter {
    public static void countEvenOdd(int[] nums) {
        int even = 0, odd = 0;
        for (int num : nums) {
            if (num % 2 == 0) { // Use the modulo operator (%) to determine if a number is even or odd[cite: 44]
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}