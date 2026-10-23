import java.util.Scanner;

abstract class Vehicle {
    abstract double calculateCharge(int hours);
}

class Bike extends Vehicle {
    double calculateCharge(int hours) { return hours * 10; }
}

class Car extends Vehicle {
    double calculateCharge(int hours) { return 30 + (Math.max(0, hours - 1) * 20); }
}

class Truck extends Vehicle {
    double calculateCharge(int hours) { return Math.max(100, hours * 50); }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle v = switch (type) {
                case "BIKE" -> new Bike();
                case "CAR" -> new Car();
                case "TRUCK" -> new Truck();
                default -> null;
            };
            
            if (v != null) {
                double charge = v.calculateCharge(hours);
                total += charge;
                System.out.printf("%s: %.2f\n", type, charge);
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}