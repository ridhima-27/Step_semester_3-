import java.util.Scanner;

abstract class Customer {
    abstract double calculateBill(double amount);
}

class StudentCustomer extends Customer {
    double calculateBill(double amount) { return amount * 0.90; }
}

class StaffCustomer extends Customer {
    double calculateBill(double amount) { return amount * 0.95; }
}

class GuestCustomer extends Customer {
    double calculateBill(double amount) { return amount + 10; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer c = switch(type) {
                case "STUDENT" -> new StudentCustomer();
                case "STAFF" -> new StaffCustomer();
                case "GUEST" -> new GuestCustomer();
                default -> null;
            };
            
            if (c != null) {
                double finalAmount = c.calculateBill(amount);
                total += finalAmount;
                System.out.printf("%s: %.2f\n", type, finalAmount);
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}