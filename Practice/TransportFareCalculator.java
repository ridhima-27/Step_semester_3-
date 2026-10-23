import java.util.Scanner;

abstract class Transport {
    abstract double calculateFare(double distance);
}

class Bus extends Transport {
    double calculateFare(double distance) { return Math.min(10.0, 2.0 + (0.10 * distance)); }
}

class Train extends Transport {
    double calculateFare(double distance) { return 3.0 + (0.15 * distance); }
}

class Metro extends Transport {
    double peakFactor;
    Metro(double peakFactor) { this.peakFactor = peakFactor; }
    double calculateFare(double distance) { return (1.50 + (0.20 * distance)) * peakFactor; }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport t = null;
            
            if (type.equals("METRO")) {
                t = new Metro(sc.nextDouble());
            } else if (type.equals("BUS")) {
                t = new Bus();
            } else if (type.equals("TRAIN")) {
                t = new Train();
            }
            
            if (t != null) {
                double fare = t.calculateFare(distance);
                total += fare;
                System.out.printf("%s: %.2f\n", type, fare);
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}