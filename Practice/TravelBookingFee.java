import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;
    protected static final double BOOKING_FEE = 50.0; //[cite: 33]

    public TravelBooking(double distance) {
        this.distance = distance;
    }

    public double calculateTotal() {
        return getBaseFare() + BOOKING_FEE; //[cite: 33]
    }

    protected abstract double getBaseFare();
}

class BusBooking extends TravelBooking {
    public BusBooking(double distance) { super(distance); }
    protected double getBaseFare() { return distance * 2.0; } //[cite: 33]
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distance) { super(distance); }
    protected double getBaseFare() { return distance * 1.5; } //[cite: 33]
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distance) { super(distance); }
    protected double getBaseFare() { return 2500.0 + (distance * 4.0); } //[cite: 33]
}

public class TravelBookingFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            TravelBooking b = switch (mode) {
                case "BUS" -> new BusBooking(distance);
                case "TRAIN" -> new TrainBooking(distance);
                case "FLIGHT" -> new FlightBooking(distance);
                default -> null;
            };

            if (b != null) {
                System.out.printf("%s: %.2f\n", mode, b.calculateTotal());
            }
        }
    }
}