import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    public double calculateCharge() { return 40.0 + (10.0 * weight); } //[cite: 25]
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    public double calculateCharge() { return 80.0 + (15.0 * weight); } //[cite: 25]
    public double calculateInsurance() { return declaredValue * 0.02; } //[cite: 25]
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    public double calculateCharge() { return 40.0 + (10.0 * weight) + 50.0; } //[cite: 25]
    public double calculateInsurance() { return declaredValue * 0.02; } //[cite: 25]
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();
            
            Parcel p = switch (type) {
                case "STANDARD" -> new StandardParcel(weight, declaredValue);
                case "EXPRESS" -> new ExpressParcel(weight, declaredValue);
                case "FRAGILE" -> new FragileParcel(weight, declaredValue);
                default -> null;
            };

            if (p != null) {
                double charge = p.calculateCharge();
                double insurance = (p instanceof Insurable) ? ((Insurable) p).calculateInsurance() : 0.0;
                double total = charge + insurance;
                grandTotal += total;
                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", type, charge, insurance, total);
            }
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
    }
}