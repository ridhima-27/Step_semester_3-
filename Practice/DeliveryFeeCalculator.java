import java.util.Scanner;

abstract class Delivery {
    abstract double calculateFee(double weight, double distance);
}

class StandardDelivery extends Delivery {
    double calculateFee(double weight, double distance) { return 5.0 + (0.50 * weight) + (0.10 * distance); }
}

class ExpressDelivery extends Delivery {
    double calculateFee(double weight, double distance) { return 15.0 + (1.00 * weight) + (0.20 * distance); }
}

class InternationalDelivery extends Delivery {
    double customsFee;
    InternationalDelivery(double customsFee) { this.customsFee = customsFee; }
    double calculateFee(double weight, double distance) { return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee; }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery delivery = null;
            
            if (type.equals("INTERNATIONAL")) {
                delivery = new InternationalDelivery(sc.nextDouble());
            } else if (type.equals("STANDARD")) {
                delivery = new StandardDelivery();
            } else if (type.equals("EXPRESS")) {
                delivery = new ExpressDelivery();
            }
            
            if (delivery != null) {
                double fee = delivery.calculateFee(weight, distance);
                total += fee;
                System.out.printf("%s: %.2f\n", type, fee);
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}