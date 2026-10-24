import java.util.Scanner;

public class DigitSumReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0, reversed = 0;
        
        while (num > 0) {
            int digit = num % 10; // Repeatedly use the modulo operator (%) by 10 to get the last digit[cite: 44, 45]
            sum += digit;
            reversed = (reversed * 10) + digit; // Build the reversed number by multiplying by 10 and adding the extracted digit[cite: 45]
            num = num / 10; // Integer division (/) by 10 to remove the last digit[cite: 45]
        }
        
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }
}