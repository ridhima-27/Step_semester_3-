import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toLowerCase();
        int vowels = 0, consonants = 0;
        
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                // Vowels are 'a', 'e', 'i', 'o', 'u'[cite: 43]
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++; // All other alphabetic characters are consonants[cite: 43]
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}