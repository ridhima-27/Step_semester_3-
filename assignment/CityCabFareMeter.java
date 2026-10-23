import java.util.Scanner;

interface NightServiceEnabled {
    boolean canProvideNightService();
}

abstract class Cab {
    protected double km;
    protected String time;

    public Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    protected abstract double getRate();

    public double calculateFare() {
        double fare = Math.max(100.0, km * getRate()); //[cite: 27]
        if (time.equals("NIGHT") && this instanceof NightServiceEnabled) {
            fare *= 1.20; //[cite: 27]
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) { super(km, time); }
    protected double getRate() { return 10.0; } //[cite: 26]
}

class SedanCab extends Cab implements NightServiceEnabled {
    public SedanCab(double km, String time) { super(km, time); }
    protected double getRate() { return 14.0; } //[cite: 26]
    public boolean canProvideNightService() { return true; }
}

class SUVCab extends Cab implements NightServiceEnabled {
    public SUVCab(double km, String time) { super(km, time); }
    protected double getRate() { return 18.0; } //[cite: 26]
    public boolean canProvideNightService() { return true; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab c = switch (cabType) {
                case "MINI" -> new MiniCab(km, time);
                case "SEDAN" -> new SedanCab(km, time);
                case "SUV" -> new SUVCab(km, time);
                default -> null;
            };

            if (c != null) {
                if (time.equals("NIGHT") && !(c instanceof NightServiceEnabled)) {
                    System.out.printf("%s: night service not available\n", cabType); //[cite: 26]
                } else {
                    double fare = c.calculateFare();
                    grandTotal += fare;
                    System.out.printf("%s: %.2f\n", cabType, fare);
                }
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}