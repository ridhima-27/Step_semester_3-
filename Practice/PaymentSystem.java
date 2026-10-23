import java.util.Scanner;

abstract class Payment {
    abstract double calculateAdjusted(double amount);
}

class CardPayment extends Payment {
    double calculateAdjusted(double amount) { return amount * 1.02; }
}

class WalletPayment extends Payment {
    double calculateAdjusted(double amount) { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    double calculateAdjusted(double amount) { return amount; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment payment = switch (type) {
                case "CARD" -> new CardPayment();
                case "WALLET" -> new WalletPayment();
                case "BANKTRANSFER" -> new BankTransferPayment();
                default -> null;
            };
            
            if (payment != null) {
                double adjusted = payment.calculateAdjusted(amount);
                total += adjusted;
                System.out.printf("%s: %.2f\n", type, adjusted);
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
