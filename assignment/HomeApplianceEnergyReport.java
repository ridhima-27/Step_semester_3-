import java.util.Scanner;

interface SaverModeEnabled {
    boolean supportsSaverMode();
}

abstract class Appliance {
    protected double hours;
    protected boolean isSaverRequested;

    public Appliance(double hours, boolean isSaverRequested) {
        this.hours = hours;
        this.isSaverRequested = isSaverRequested;
    }

    protected abstract double getPowerRating();

    public double calculateUnits() {
        double units = (getPowerRating() * hours) / 1000.0; //[cite: 27]
        if (isSaverRequested && this instanceof SaverModeEnabled) {
            units *= 0.75; //[cite: 27]
        }
        return units;
    }

    public double calculateCost(double units) {
        return units * 8.0; //[cite: 27]
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saver) { super(hours, saver); }
    protected double getPowerRating() { return 150.0; } //[cite: 27]
}

class AC extends Appliance implements SaverModeEnabled {
    public AC(double hours, boolean saver) { super(hours, saver); }
    protected double getPowerRating() { return 1500.0; } //[cite: 27]
    public boolean supportsSaverMode() { return true; }
}

class TV extends Appliance {
    public TV(double hours, boolean saver) { super(hours, saver); }
    protected double getPowerRating() { return 100.0; } //[cite: 27]
}

class Washer extends Appliance implements SaverModeEnabled {
    public Washer(double hours, boolean saver) { super(hours, saver); }
    protected double getPowerRating() { return 500.0; } //[cite: 27]
    public boolean supportsSaverMode() { return true; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equals("SAVER");

            Appliance a = switch (type) {
                case "FRIDGE" -> new Fridge(hours, saverRequested);
                case "AC" -> new AC(hours, saverRequested);
                case "TV" -> new TV(hours, saverRequested);
                case "WASHER" -> new Washer(hours, saverRequested);
                default -> null;
            };

            if (a != null) {
                if (saverRequested && !(a instanceof SaverModeEnabled)) {
                    System.out.printf("%s: saver mode not supported\n", type); //[cite: 27]
                } else {
                    double units = a.calculateUnits();
                    double cost = a.calculateCost(units);
                    grandTotal += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", type, units, cost);
                }
            }
        }
        System.out.printf("Total Cost: %.2f\n", grandTotal);
    }
}