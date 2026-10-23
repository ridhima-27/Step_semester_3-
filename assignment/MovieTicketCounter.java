import java.util.Scanner;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }
    
    public double calculateTotal() {
        return (getBasePrice() + CONVENIENCE_FEE) * count;
    }
    
    protected abstract double getBasePrice();
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) { super(count); }
    protected double getBasePrice() { return 150.0; } //[cite: 24]
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) { super(count); }
    protected double getBasePrice() { return 250.0; } //[cite: 24]
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) { super(count); }
    protected double getBasePrice() { return 400.0; } //[cite: 24]
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket t = switch (type) {
                case "REGULAR" -> new RegularTicket(count);
                case "PREMIUM" -> new PremiumTicket(count);
                case "RECLINER" -> new ReclinerTicket(count);
                default -> null;
            };
            
            if (t != null) {
                double amount = t.calculateTotal();
                grandTotal += amount;
                System.out.printf("%s: %.2f\n", type, amount);
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}