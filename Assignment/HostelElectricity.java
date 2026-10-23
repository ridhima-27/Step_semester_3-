import java.util.Scanner;

abstract class Room {
    abstract double calculateBill(int units);
}

class SingleRoom extends Room {
    double calculateBill(int units) { return units * 8.0; }
}

class SharedRoom extends Room {
    int occupants;
    SharedRoom(int occupants) { this.occupants = occupants; }
    double calculateBill(int units) { return (units * 6.0) / occupants; }
}

class ACRoom extends Room {
    double calculateBill(int units) { return (units * 10.0) + 200.0; }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r = null;
            
            if (type.equals("SHARED")) {
                r = new SharedRoom(sc.nextInt());
            } else if (type.equals("SINGLE")) {
                r = new SingleRoom();
            } else if (type.equals("AC")) {
                r = new ACRoom();
            }
            
            if (r != null) {
                double bill = r.calculateBill(units);
                total += bill;
                System.out.printf("%s: %.2f\n", type, bill);
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}